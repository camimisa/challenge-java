package com.camila.challenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@JsonRootName(value = "Genero")
public class GeneroModel {

	@JsonProperty(access = Access.WRITE_ONLY)
	private int idGenero;
	private String nombre;
	private String imagenUrl;
	@JsonProperty(access = Access.WRITE_ONLY)
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
