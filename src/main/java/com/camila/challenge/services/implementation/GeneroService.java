package com.camila.challenge.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.entities.Genero;
import com.camila.challenge.repositories.IGeneroRepository;
import com.camila.challenge.services.IGeneroService;

@Service("generoService")
public class GeneroService implements IGeneroService{

	@Autowired
	@Qualifier("generoRepository")
	private IGeneroRepository generoRepository;

	@Override
	public List<Genero> getAll() {
		return generoRepository.findAll() ;
	}

	@Override
	public Genero insertOrUpdate(Genero object) {
		return generoRepository.save(object);
	}

	@Override
	public boolean remove(int id) {
		try {
			generoRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Genero findById(int id) {
		return generoRepository.findByIdGenero(id);
	}

}
