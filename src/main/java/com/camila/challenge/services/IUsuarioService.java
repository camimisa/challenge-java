package com.camila.challenge.services;

import java.util.List;

import com.camila.challenge.entities.Usuario;

public interface IUsuarioService {

	public abstract Usuario findByEmail(String email);
	public abstract Usuario findById(int id);
	public List<Usuario> getAll();
	public Usuario insertOrUpdate(Usuario usuario);
	public boolean remove(int id);

}
