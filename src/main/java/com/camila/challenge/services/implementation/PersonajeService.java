package com.camila.challenge.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.entities.Personaje;
import com.camila.challenge.repositories.IPersonajeRepository;
import com.camila.challenge.services.IPersonajeService;

@Service("personajeService")
public class PersonajeService implements IPersonajeService{

	@Autowired
	@Qualifier("personajeRepository")
	private IPersonajeRepository personajeRepository;
	
	@Override
	public List<Personaje> getAll() {
		return personajeRepository.findAll();
	}

	@Override
	public Personaje insertOrUpdate(Personaje object) {
		return personajeRepository.save(object);
	}

	@Override
	public boolean remove(int id) {
		try {
			personajeRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Personaje findById(int id) {
		return personajeRepository.findByIdPersonaje(id);
	}

}
