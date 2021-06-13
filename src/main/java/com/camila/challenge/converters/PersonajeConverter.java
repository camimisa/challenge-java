package com.camila.challenge.converters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.camila.challenge.entities.Personaje;
import com.camila.challenge.models.PersonajeModel;

@Component("personajeConverter")
public class PersonajeConverter {

	public PersonajeModel entidadAModelo(Personaje personaje) {
		return new PersonajeModel(personaje.getIdPersonaje(),personaje.getNombre(), personaje.getImagen(),
				personaje.getEdad(), personaje.getPeso(), personaje.getHistoria(), personaje.getPeliculas());
	}

	public Set<PersonajeModel> entidadAModelo(Set<Personaje> personajes) {
		Set<PersonajeModel> listaModels = new HashSet<PersonajeModel>();
		for(Personaje p : personajes)
			listaModels.add(this.entidadAModelo(p));
		return listaModels;
	}
	
	public Personaje modeloAEntidad(PersonajeModel personajeModel) {
		return new Personaje(personajeModel.getIdPersonaje(),personajeModel.getNombre(), personajeModel.getImagen(),
				personajeModel.getEdad(), personajeModel.getPeso(), personajeModel.getHistoria(), personajeModel.getPeliculas());
	}

	public Set<Personaje> modeloAEntidad(Set<PersonajeModel> personajes) {
		Set<Personaje> lista = new HashSet<Personaje>();
		for(PersonajeModel p : personajes)
			lista.add(this.modeloAEntidad(p));
		return lista;
	}

	public List<PersonajeModel> entidadAModelo(List<Personaje> personajes) {
		List<PersonajeModel> listaModels = new ArrayList<PersonajeModel>();
		for(Personaje p : personajes)
			listaModels.add(this.entidadAModelo(p));
		return listaModels;
	}
}
