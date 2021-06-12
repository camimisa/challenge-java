package com.camila.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camila.challenge.entities.Personaje;
import com.camila.challenge.services.IPersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

	@Autowired
	@Qualifier("personajeService")
	private IPersonajeService personajeService;
	
	@GetMapping
	public ResponseEntity<List<Personaje>>get(){
		return new ResponseEntity<List<Personaje>>(personajeService.getAll(),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Personaje>create(@RequestBody Personaje personaje){
		return new ResponseEntity<Personaje>(personajeService.insertOrUpdate(personaje),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean>delete(@PathVariable("id") int idPersonaje){
		return new ResponseEntity<Boolean>(personajeService.remove(idPersonaje),HttpStatus.NO_CONTENT);
	}
}
