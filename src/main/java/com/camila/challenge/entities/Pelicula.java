package com.camila.challenge.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPelicula;
	
	@Column(name = "titulo", nullable=false)
	private String titulo;
	
	@Column(name = "imagen", nullable=false)
	private String imagen;
	
	@Column(name = "calificacion", nullable=false)
	private int calificacion;
	
	@Column(name = "fecha", nullable=false)
	private LocalDate fecha;
	
    @ManyToOne()
    @JoinColumn(name = "id_genero")
    private Genero genero;
    
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="peliculas")
	private Set<Personaje> personajes;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Pelicula() {
		this.personajes= new HashSet<>();
	}
	
	
	public Pelicula(int idPelicula, String titulo, String imagen, int calificacion, LocalDate fecha, Genero genero, Set<Personaje> personajes) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.imagen = imagen;
		this.calificacion = calificacion;
		this.fecha = fecha;
		this.genero = genero;
		this.personajes = personajes;
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

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}


	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", imagen=" + imagen + ", calificacion="
				+ calificacion + ", fecha=" + fecha + "]";
	}
	
	
}
