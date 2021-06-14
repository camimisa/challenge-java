package com.camila.challenge.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.converters.GeneroConverter;
import com.camila.challenge.converters.PeliculaConverter;
import com.camila.challenge.converters.PersonajeConverter;
import com.camila.challenge.entities.Genero;
import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.entities.Personaje;
import com.camila.challenge.models.PeliculaModel;
import com.camila.challenge.models.PersonajeModel;
import com.camila.challenge.repositories.IPeliculaRepository;
import com.camila.challenge.services.IGeneroService;
import com.camila.challenge.services.IPeliculaService;
import com.camila.challenge.services.IPersonajeService;

@Service("peliculaService")
public class PeliculaService implements IPeliculaService{

	@Autowired
	@Qualifier("peliculaRepository")
	private IPeliculaRepository peliculaRepository;

	@Autowired
	@Qualifier("personajeService")
	private IPersonajeService personajeService;
	@Autowired
	@Qualifier("peliculaConverter")
	private PeliculaConverter peliculaConverter;
	
	@Autowired
	@Qualifier("personajeConverter")
	private PersonajeConverter personajeConverter;
	
	@Autowired
	@Qualifier("generoConverter")
	private GeneroConverter generoConverter;
	@Autowired
	@Qualifier("generoService")
	private IGeneroService generoService;
	
	@Override
	public List<PeliculaModel> getAll() {
		return peliculaConverter.entidadAModelo(peliculaRepository.findAll());
	}

	@Override
	public PeliculaModel insertOrUpdate(PeliculaModel object) {
		Pelicula pelicula = new Pelicula();
		Genero genero = null;
		try {
			pelicula = peliculaConverter.modeloAEntidad(object,true);
			genero = generoService.findById(pelicula.getGenero().getIdGenero());
			if(genero == null)
				genero = generoService.insertOrUpdate(generoConverter.modeloAEntidad(object.getGenero()));
			pelicula.setGenero(genero);
			
			pelicula = peliculaRepository.save(pelicula);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return peliculaConverter.entidadAModelo(pelicula,true);
	}

	@Override
	public boolean remove(int id) {
		try {
			peliculaRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public PeliculaModel findById(int id) {
		return peliculaConverter.entidadAModelo(peliculaRepository.findByIdPelicula(id),true);
	}

	@Override
	public PeliculaModel findByTitulo(String titulo) {
		return peliculaConverter.entidadAModelo(peliculaRepository.findByTitulo(titulo),true);
	}

	@Override
	public List<PeliculaModel> findAllByFechaASC() {
		return peliculaConverter.entidadAModelo(peliculaRepository.findAllByFechaASC());
	}

	@Override
	public List<PeliculaModel> findAllByFechaDESC() {
		return peliculaConverter.entidadAModelo(peliculaRepository.findAllByFechaDESC());
	}

	@Override
	public List<PeliculaModel> findAllByGenero(int id) {
		return peliculaConverter.entidadAModelo(peliculaRepository.findAllByIdGenero(id));
	}

	@Override
	public boolean addCharacterToMovie(int idCharacter, int idMovie) {
		Pelicula pelicula = peliculaRepository.findByIdPelicula(idMovie);
		Personaje personaje = personajeConverter.modeloAEntidad(personajeService.findById(idCharacter), true);
		pelicula.getPersonajes().add(personaje);
		personaje.getPeliculas().add(pelicula);
		this.insertOrUpdate(peliculaConverter.entidadAModelo(pelicula, true));
		personajeService.insertOrUpdate(personajeConverter.entidadAModelo(personaje, true));
		return false;
	}
	
	@Override
	public boolean addCharacterToMovie(PersonajeModel personajeModel, int idMovie) {
		Pelicula pelicula = peliculaRepository.findByIdPelicula(idMovie);
		Personaje personaje = personajeConverter.modeloAEntidad(personajeModel, true);
		pelicula.getPersonajes().add(personaje);
		this.insertOrUpdate(peliculaConverter.entidadAModelo(pelicula, true));
		personajeService.insertOrUpdate(personajeConverter.entidadAModelo(personaje, true));
		return false;
	}
}
