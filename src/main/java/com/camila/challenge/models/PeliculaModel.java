package com.camila.challenge.models;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

public class PeliculaModel extends PeliculaParcialModel{

    private GeneroModel genero;
    private int clasificacion;
    private Set<PersonajeModel>personajes;
	public PeliculaModel() {}

	public PeliculaModel(int idPelicula, String titulo, LocalDate fecha, String imagen, int clasificacion, GeneroModel generoModel, Set<PersonajeModel> personajes) {
		super(idPelicula,titulo,imagen,fecha);
		this.genero = generoModel;
		this.clasificacion = clasificacion;
		this.personajes = personajes;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public int getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public GeneroModel getGenero() {
		return genero;
	}

	public void setGenero(GeneroModel genero) {
		this.genero = genero;
	}

	@JsonView(PeliculaModel.class)
	public Set<PersonajeModel> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<PersonajeModel> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "PeliculaModel [idPelicula=" + idPelicula + ", titulo=" + titulo + ", fecha=" + fecha + ", imagen="
				+ imagen + ", genero=" + genero + "]";
	}
	
	
}
