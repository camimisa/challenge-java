package com.camila.challenge.models;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;

@JsonRootName(value = "Pelicula")
public class PeliculaParcialModel {
	@JsonView(PeliculaParcialModel.class)
	protected int idPelicula;
	@JsonView(PeliculaParcialModel.class)
	@NotNull
	protected String titulo;
	@JsonView(PeliculaParcialModel.class)
	protected String imagenUrl;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	protected String imagen;
	@JsonView(PeliculaParcialModel.class)
	@NotNull
	protected LocalDate fecha;
	
	public PeliculaParcialModel() {}

	public PeliculaParcialModel(int idPelicula, String titulo, String imagen, LocalDate fechaCreacion) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fechaCreacion;
		this.imagenUrl = "/movies/image/" + idPelicula;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fechaCreacion) {
		this.fecha = fechaCreacion;
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
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		PeliculaParcialModel other = (PeliculaParcialModel) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}
