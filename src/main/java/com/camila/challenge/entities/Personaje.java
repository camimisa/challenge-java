package com.camila.challenge.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "personaje")
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonaje;
	
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@Column(name = "imagen", nullable=false)
	private String imagen;
	
	@Column(name = "edad", nullable=false)
	private int edad;
	
	@Column(name = "peso", nullable=false)
	private double peso;
	
	@Column(name = "historia", nullable=false)
	private String historia;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "personaje_pelicula",
		joinColumns = {@JoinColumn(name = "id_personaje", nullable = false)},
		inverseJoinColumns = {@JoinColumn(name = "id_pelicula", nullable = false)}
	)
	private Set<Pelicula> peliculas;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	
	public Personaje() {}
	
	
	public Personaje(int idPersonaje, String nombre, String imagen, int edad, double peso, String historia,
			Set<Pelicula> peliculas) {
		super();
		this.idPersonaje = idPersonaje;
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
	}


	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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


	@Override
	public String toString() {
		return "Personaje [idPersonaje=" + idPersonaje + ", nombre=" + nombre + ", imagen=" + imagen + ", edad=" + edad
				+ ", peso=" + peso + ", historia=" + historia + ", peliculas=" + peliculas + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
}
