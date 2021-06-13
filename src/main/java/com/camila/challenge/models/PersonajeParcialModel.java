package com.camila.challenge.models;

import com.fasterxml.jackson.annotation.JsonView;

public class PersonajeParcialModel {
	@JsonView(PersonajeParcialModel.class)
	protected int idPersonaje;
	@JsonView(PersonajeParcialModel.class)
	protected String nombre;
	@JsonView(PersonajeParcialModel.class)
	protected String imagen;
	
	public PersonajeParcialModel() {}

	public PersonajeParcialModel(int idPersonaje, String nombre, String imagen) {
		super();
		this.idPersonaje = idPersonaje;
		this.nombre = nombre;
		this.imagen = imagen;
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
	
}
