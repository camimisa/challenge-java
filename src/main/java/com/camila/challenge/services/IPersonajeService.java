package com.camila.challenge.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.camila.challenge.entities.Personaje;
import com.camila.challenge.models.PersonajeModel;

public interface IPersonajeService {

	public List<PersonajeModel> getAll();
	public PersonajeModel insertOrUpdate(PersonajeModel object);
	public boolean remove(int id);
	PersonajeModel findById(int id);
	public abstract PersonajeModel findByNombre(String nombre);
	public abstract List<PersonajeModel> findByEdad(int edad);
	public abstract List<PersonajeModel> findByPeso(double peso);
	public abstract List<PersonajeModel> findByPelicula(int idPelicula);
}
