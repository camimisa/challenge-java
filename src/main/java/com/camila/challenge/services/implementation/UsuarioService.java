package com.camila.challenge.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.camila.challenge.entities.Rol;
import com.camila.challenge.entities.Usuario;
import com.camila.challenge.repositories.IUsuarioRepository;
import com.camila.challenge.services.IUsuarioService;
/*
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
		return usuarioRepository.save(usuario);
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
		Usuario user = usuarioRepository.findByEmail(username);
		return buildUser(user, buildGrantedAuthorities(user.getRol()));
	}
	
	private User buildUser(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getEmail(), usuario.getClave(), usuario.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Rol rol) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre()));

		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}*/