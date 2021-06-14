package com.camila.challenge.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.camila.challenge.entities.Usuario;
import com.camila.challenge.repositories.IUsuarioRepository;
import com.camila.challenge.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService, IUsuarioService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findByIdUsuario(id);
	}

	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario insertOrUpdate(Usuario usuario) {
		usuario.setClave(encoder.encode(usuario.getClave()));
		usuario.setEnabled(true);
		if(this.findByEmail(usuario.getEmail()) == null)
			usuario = usuarioRepository.save(usuario);
		else
			usuario = null;
		return usuario;
	}

	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getEmail(), usuario.getClave(), buildGrantedAuthorities());
	}
	
	
	private List<GrantedAuthority> buildGrantedAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}