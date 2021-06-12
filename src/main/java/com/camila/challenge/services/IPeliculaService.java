package com.camila.challenge.services;

import java.util.List;
import com.camila.challenge.entities.Pelicula;

public interface IPeliculaService {
	public List<Pelicula>getAll();
	public Pelicula insertOrUpdate(Pelicula object);
	public boolean remove(int id);
	public Pelicula findById(int id);
	public abstract Pelicula findByTitulo(String title);
	public abstract List<Pelicula> findAllByFechaASC();
	public abstract List<Pelicula> findAllByFechaDESC();
	public abstract List<Pelicula> findAllByGenero(int id);
}
