package com.camila.challenge.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PersonajeModel extends PersonajeParcialModel {

	@NotNull
	@Min(1)
	@Max(150)
	private int edad;
	@NotNull
	@Min(1)
	private double peso;
	@NotNull
	private String historia;
	private Set<PeliculaModel> peliculas;
	public PersonajeModel() {
		this.peliculas = new HashSet<>();
	}
	
	
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
