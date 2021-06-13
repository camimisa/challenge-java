package com.camila.challenge.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.camila.challenge.entities.Personaje;

@Repository("personajeRepository")
public interface IPersonajeRepository extends JpaRepository<Personaje, Serializable> {

	public abstract Personaje findByIdPersonaje(int id);
	public abstract Personaje findByNombre(String nombre);
	public abstract List<Personaje> findByEdad(int edad);
	public abstract List<Personaje> findByPeso(double peso);
	@Query(value="select p from Personaje p join fetch p.peliculas pel where pel.idPelicula = :id")
	public abstract List<Personaje> findByPelicula(@Param("id")int idPelicula);
}
