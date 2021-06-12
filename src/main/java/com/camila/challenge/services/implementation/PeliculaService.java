package com.camila.challenge.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.repositories.IPeliculaRepository;
import com.camila.challenge.services.IPeliculaService;

@Service("peliculaService")
public class PeliculaService implements IPeliculaService{

	@Autowired
	@Qualifier("peliculaRepository")
	private IPeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> getAll() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula insertOrUpdate(Pelicula object) {
		return peliculaRepository.save(object);
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
	public Pelicula findById(int id) {
		return peliculaRepository.findByIdPelicula(id);
	}

	@Override
	public Pelicula findByTitulo(String titulo) {
		return peliculaRepository.findByTitulo(titulo);
	}

	@Override
	public List<Pelicula> findAllByFechaASC() {
		return peliculaRepository.findAllByFechaASC();
	}

	@Override
	public List<Pelicula> findAllByFechaDESC() {
		return peliculaRepository.findAllByFechaDESC();
	}

	@Override
	public List<Pelicula> findAllByGenero(int id) {
		return peliculaRepository.findAllByGenero(id);
	}
}
