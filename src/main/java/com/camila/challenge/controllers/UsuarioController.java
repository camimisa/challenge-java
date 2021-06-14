package com.camila.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camila.challenge.entities.Usuario;
import com.camila.challenge.models.PersonajeModel;
import com.camila.challenge.services.IPersonajeService;
import com.camila.challenge.services.IUsuarioService;

@RestController
@RequestMapping("/auth/")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	@PostMapping("register")
	public ResponseEntity<Usuario>create(@RequestBody Usuario usuario){
		Usuario nuevoUsuario = null;
		ResponseEntity<Usuario> response = null;
		try {
			nuevoUsuario = usuarioService.insertOrUpdate(usuario);
			response = new ResponseEntity<Usuario>(nuevoUsuario,HttpStatus.CREATED);
		}
		catch(Exception e) {
			response = new ResponseEntity<Usuario>(nuevoUsuario,HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
