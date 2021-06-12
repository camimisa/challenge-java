package com.camila.challenge.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.camila.challenge.entities.Personaje;

@Repository("personajeRepository")
public interface IPersonajeRepository extends JpaRepository<Personaje, Serializable> {

	public abstract Personaje findByIdPersonaje(int id);
}
