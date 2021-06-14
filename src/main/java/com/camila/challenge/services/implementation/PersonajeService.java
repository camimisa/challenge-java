package com.camila.challenge.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camila.challenge.converters.PersonajeConverter;
import com.camila.challenge.entities.Personaje;
import com.camila.challenge.models.PersonajeModel;
import com.camila.challenge.repositories.IPersonajeRepository;
import com.camila.challenge.services.IPersonajeService;

@Service("personajeService")
public class PersonajeService implements IPersonajeService{

	@Autowired
	@Qualifier("personajeRepository")
	private IPersonajeRepository personajeRepository;
	
	@Autowired
	@Qualifier("personajeConverter")
	private PersonajeConverter personajeConverter;
	@Override
	public List<PersonajeModel> getAll() {
		return personajeConverter.entidadAModelo(personajeRepository.findAll());
	}

	@Override
	public PersonajeModel insertOrUpdate(PersonajeModel object) {
		Personaje personaje = personajeConverter.modeloAEntidad(object,true);
		return personajeConverter.entidadAModelo(personajeRepository.save(personaje),true);
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
	public PersonajeModel findById(int id) {
		return personajeConverter.entidadAModelo(personajeRepository.findByIdPersonaje(id),true);
	}

	@Override
	public PersonajeModel findByNombre(String nombre) {
		return personajeConverter.entidadAModelo(personajeRepository.findByNombre(nombre),true);
	}

	@Override
	public List<PersonajeModel> findByEdad(int edad) {
		return personajeConverter.entidadAModelo(personajeRepository.findByEdad(edad));
	}

	@Override
	public List<PersonajeModel> findByPeso(double peso) {
		return personajeConverter.entidadAModelo(personajeRepository.findByPeso(peso));
	}

	@Override
	public List<PersonajeModel> findByPelicula(int idPelicula) {
		return personajeConverter.entidadAModelo(personajeRepository.findByPelicula(idPelicula));
	}



}
