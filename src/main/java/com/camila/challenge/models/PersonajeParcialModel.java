package com.camila.challenge.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonView;

@JsonRootName(value = "Personaje")
public class PersonajeParcialModel {
	@JsonView(PersonajeParcialModel.class)
	@JsonIgnore
	protected int idPersonaje;
	@JsonView(PersonajeParcialModel.class)
	@NotNull
	protected String nombre;
	@JsonView(PersonajeParcialModel.class)
	protected String imagenUrl;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	protected String imagen;
	
	public PersonajeParcialModel() {}

	public PersonajeParcialModel(int idPersonaje, String nombre, String imagen) {
		super();
		this.idPersonaje = idPersonaje;
		this.nombre = nombre;
		this.imagen = imagen;
		this.imagenUrl = "/characters/image/" + idPersonaje;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersojaje) {
		this.idPersonaje = idPersojaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	
}
