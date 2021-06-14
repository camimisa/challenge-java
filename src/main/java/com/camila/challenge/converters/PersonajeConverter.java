package com.camila.challenge.converters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.entities.Personaje;
import com.camila.challenge.models.PeliculaModel;
import com.camila.challenge.models.PersonajeModel;

@Component("personajeConverter")
public class PersonajeConverter {

	@Autowired
	@Qualifier("peliculaConverter")
	private PeliculaConverter peliculaConverter;
	
	public PersonajeModel entidadAModelo(Personaje personaje, boolean esPersonaje) {
		if(personaje == null)return null;
		PersonajeModel personajeModel =  new PersonajeModel(personaje.getIdPersonaje(),personaje.getNombre(), personaje.getImagen(),
				personaje.getEdad(), personaje.getPeso(), personaje.getHistoria(), new HashSet<>());
		if(esPersonaje) {
			for(Pelicula p : personaje.getPeliculas()) {
				personajeModel.getPeliculas().add(peliculaConverter.entidadAModelo(p,!esPersonaje));
			}
		}
		return personajeModel;
	}

	public Set<PersonajeModel> entidadAModelo(Set<Personaje> personajes) {
		Set<PersonajeModel> listaModels = new HashSet<PersonajeModel>();
		for(Personaje p : personajes)
			listaModels.add(this.entidadAModelo(p,true));
		return listaModels;
	}
	
	public Personaje modeloAEntidad(PersonajeModel personajeModel, boolean esPersonaje) {
		if(personajeModel == null)return null;
		Personaje personaje = new Personaje(personajeModel.getIdPersonaje(),personajeModel.getNombre(), personajeModel.getImagen(),
				personajeModel.getEdad(), personajeModel.getPeso(), personajeModel.getHistoria(), new HashSet<>());
		if(esPersonaje) {
		for(PeliculaModel p : personajeModel.getPeliculas())
			personaje.getPeliculas().add(peliculaConverter.modeloAEntidad(p,false));
		}
		return personaje;
	}

	public Set<Personaje> modeloAEntidad(Set<PersonajeModel> personajes) {
		Set<Personaje> lista = new HashSet<Personaje>();
		for(PersonajeModel p : personajes)
			lista.add(this.modeloAEntidad(p,true));
		return lista;
	}

	public List<PersonajeModel> entidadAModelo(List<Personaje> personajes) {
		List<PersonajeModel> listaModels = new ArrayList<PersonajeModel>();
		for(Personaje p : personajes) {
			listaModels.add(this.entidadAModelo(p,true));
		}
		return listaModels;
	}
}
