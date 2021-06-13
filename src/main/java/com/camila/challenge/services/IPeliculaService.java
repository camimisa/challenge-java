package com.camila.challenge.services;

import java.util.List;


import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.models.PeliculaModel;
import com.camila.challenge.models.PersonajeModel;

public interface IPeliculaService {
	public List<PeliculaModel> getAll();
	public PeliculaModel insertOrUpdate(PeliculaModel object);
	public boolean remove(int id);
	public PeliculaModel findById(int id);
	public abstract PeliculaModel findByTitulo(String title);
	public abstract List<PeliculaModel> findAllByFechaASC();
	public abstract List<PeliculaModel> findAllByFechaDESC();
	public abstract List<PeliculaModel> findAllByGenero(int id);
}
