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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonajeParcialModel other = (PersonajeParcialModel) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
