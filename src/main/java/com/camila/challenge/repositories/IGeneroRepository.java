package com.camila.challenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camila.challenge.entities.Genero;
@Repository("generoRepository")
public interface IGeneroRepository extends JpaRepository<Genero, Serializable> {

	public abstract Genero findByIdGenero(int id);
	
}
