package com.camila.challenge.models;

import java.util.Set;

import com.camila.challenge.entities.Pelicula;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

public class PersonajeModel extends PersonajeParcialModel {

	@JsonView(PersonajeModel.class)
	private int edad;
	@JsonView(PersonajeModel.class)
	private double peso;
	@JsonView(PersonajeModel.class)
	private String historia;
	@JsonView(PersonajeModel.class)
	private Set<PeliculaModel> peliculas;
	
	public PersonajeModel(int idPersonaje, String nombre, String imagen, int edad, double peso, String historia,
			Set<PeliculaModel> peliculas) {
		super(idPersonaje, nombre, imagen);
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public Set<PeliculaModel> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(Set<PeliculaModel> peliculas) {
		this.peliculas = peliculas;
	}


}
