package com.camila.challenge.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

public class PeliculaParcialModel {
	@JsonView(PeliculaParcialModel.class)
	protected int idPelicula;
	@JsonView(PeliculaParcialModel.class)
	protected String titulo;
	@JsonView(PeliculaParcialModel.class)
	protected String imagen;
	@JsonView(PeliculaParcialModel.class)
	protected LocalDate fecha;
	
	public PeliculaParcialModel() {}

	public PeliculaParcialModel(int idPelicula, String titulo, String imagen, LocalDate fechaCreacion) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.imagen = imagen;
		this.fecha = fechaCreacion;
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
	
}
