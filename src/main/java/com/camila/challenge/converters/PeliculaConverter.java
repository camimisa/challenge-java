package com.camila.challenge.converters;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.models.PeliculaModel;

@Component("peliculaConverter")
public class PeliculaConverter {
	
	@Autowired
	@Qualifier("personajeConverter")
	private PersonajeConverter personajeConverter;
	
	@Autowired
	@Qualifier("generoConverter")
	private GeneroConverter generoConverter;

	
	public PeliculaModel entidadAModelo(Pelicula pelicula) {
		PeliculaModel peliculaModel = new PeliculaModel(pelicula.getIdPelicula(),pelicula.getTitulo(),pelicula.getFecha(),
				pelicula.getImagen(),pelicula.getCalificacion(),
					generoConverter.entidadAModelo(pelicula.getGenero()),personajeConverter.entidadAModelo(pelicula.getPersonajes()));
		
		return peliculaModel;
	}
	

	public List<PeliculaModel> entidadAModelo(List<Pelicula>peliculas){
		List<PeliculaModel> listaModels =  new ArrayList<PeliculaModel>();
		for(Pelicula p : peliculas)
			listaModels.add(this.entidadAModelo(p));
		return listaModels;
	}

	public Pelicula modeloAEntidad(PeliculaModel object) {
		return new Pelicula(object.getIdPelicula(), object.getTitulo(), object.getImagen(),
				object.getClasificacion(),object.getFecha(), 
				generoConverter.modeloAEntidad(object.getGenero()),personajeConverter.modeloAEntidad(object.getPersonajes()));
	}
}
