package com.camila.challenge.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camila.challenge.entities.Pelicula;

@Repository("peliculaRepository")
public interface IPeliculaRepository extends JpaRepository<Pelicula, Serializable> {

	public abstract Pelicula findByTitulo(String title);
	public abstract Pelicula findByIdPelicula(int id);
	@Query(value ="select * from pelicula order by fecha asc", nativeQuery=true)
	public abstract List<Pelicula> findAllByFechaASC();
	@Query(value ="select * from pelicula order by fecha desc", nativeQuery=true)
	public abstract List<Pelicula> findAllByFechaDESC();
	@Query(value ="select * from pelicula where id_genero = :id", nativeQuery=true)
	public abstract List<Pelicula> findAllByIdGenero(@Param("id")int id);

}
