package com.camila.challenge.models;

import java.util.Set;

import com.camila.challenge.entities.Pelicula;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonajeModel extends PersonajeParcialModel {

	private int edad;
	private double peso;
	private String historia;
	private Set<Pelicula> peliculas;
	public PersonajeModel(int idPersonaje, String nombre, String imagen, int edad, double peso, String historia,
			Set<Pelicula> peliculas) {
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
	@JsonBackReference
	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}


}
