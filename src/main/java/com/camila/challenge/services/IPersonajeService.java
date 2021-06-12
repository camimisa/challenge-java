package com.camila.challenge.services;

import java.util.List;

import com.camila.challenge.entities.Personaje;

public interface IPersonajeService {

	public List<Personaje> getAll();
	public Personaje insertOrUpdate(Personaje object);
	public boolean remove(int id);
	Personaje findById(int id);
}
