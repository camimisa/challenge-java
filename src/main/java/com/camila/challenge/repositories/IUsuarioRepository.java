package com.camila.challenge.repositories;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camila.challenge.entities.Usuario;


@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public abstract Usuario findByEmail(String email);
	public abstract Usuario findByIdUsuario(int id);
	
}
