package com.camila.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName(value = "Genero")
public class GeneroModel {

	@JsonIgnore
	private int idGenero;
	private String nombre;
	private String imagenUrl;
	@JsonIgnore
	private String image;
	
	public GeneroModel(int idGenero, String nombre, String image) {
		super();
		this.idGenero = idGenero;
		this.nombre = nombre;
		this.image = image;
		this.setImagenUrl("/movies/genre/" + idGenero);
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	

}
