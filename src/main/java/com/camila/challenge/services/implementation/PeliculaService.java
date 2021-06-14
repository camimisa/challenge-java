package com.camila.challenge.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.converters.PeliculaConverter;
import com.camila.challenge.converters.PersonajeConverter;
import com.camila.challenge.entities.Genero;
import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.models.PeliculaModel;
import com.camila.challenge.repositories.IPeliculaRepository;
import com.camila.challenge.services.IGeneroService;
import com.camila.challenge.services.IPeliculaService;

@Service("peliculaService")
public class PeliculaService implements IPeliculaService{

	@Autowired
	@Qualifier("peliculaRepository")
	private IPeliculaRepository peliculaRepository;

	@Autowired
	@Qualifier("peliculaConverter")
	private PeliculaConverter peliculaConverter;
	
	@Autowired
	@Qualifier("personajeConverter")
	private PersonajeConverter personajeConverter;
	
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
				genero = generoService.insertOrUpdate(genero);
			pelicula.setGenero(genero);
			pelicula = peliculaRepository.save(pelicula);
		} catch (Exception e) {}
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
		return peliculaConverter.entidadAModelo(peliculaRepository.findAllByGenero(id));
	}


}
