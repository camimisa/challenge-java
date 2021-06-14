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
import com.camila.challenge.models.PersonajeParcialModel;

@Component("peliculaConverter")
public class PeliculaConverter {
	
	@Autowired
	@Qualifier("personajeConverter")
	private PersonajeConverter personajeConverter;
	
	@Autowired
	@Qualifier("generoConverter")
	private GeneroConverter generoConverter;

	
	public PeliculaModel entidadAModelo(Pelicula pelicula, boolean esPelicula) {
		if(pelicula == null)return null;
		PeliculaModel peliculaModel = new PeliculaModel(pelicula.getIdPelicula(),pelicula.getTitulo(),pelicula.getFecha(),
				pelicula.getImagen(),pelicula.getCalificacion(),
					generoConverter.entidadAModelo(pelicula.getGenero()),new HashSet<>());
		
		if(esPelicula) {
			for(Personaje p : pelicula.getPersonajes()) {
				peliculaModel.getPersonajes().add(personajeConverter.entidadAModelo(p,false));
			}
		}
		
		return peliculaModel;
	}
	

	public List<PeliculaModel> entidadAModelo(List<Pelicula>peliculas){
		List<PeliculaModel> listaModels =  new ArrayList<PeliculaModel>();
		for(Pelicula p : peliculas) {
			listaModels.add(this.entidadAModelo(p,true));
			}
		return listaModels;
	}

	public Pelicula modeloAEntidad(PeliculaModel object, Boolean esPelicula) {
		if(object == null)return null;
		Pelicula pelicula = new Pelicula(object.getIdPelicula(), object.getTitulo(), object.getImagen(),
				object.getClasificacion(),object.getFecha(), 
				generoConverter.modeloAEntidad(object.getGenero()),new HashSet<>());
		
		if(esPelicula) {
			for(PersonajeModel p : object.getPersonajes())
			pelicula.getPersonajes().add(personajeConverter.modeloAEntidad(p,false));
		}
		
		return pelicula;
	}

}
