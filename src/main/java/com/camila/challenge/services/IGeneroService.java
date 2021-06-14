package com.camila.challenge.services;

import java.util.List;


import com.camila.challenge.entities.Genero;


public interface IGeneroService {

	public List<Genero>getAll();
	public Genero insertOrUpdate(Genero object);
	public boolean remove(int id);
	public Genero findById(int id);
}
