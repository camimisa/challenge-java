package com.camila.challenge.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camila.challenge.models.PersonajeModel;
import com.camila.challenge.models.PersonajeParcialModel;
import com.camila.challenge.services.IPersonajeService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

	@Autowired
	@Qualifier("personajeService")
	private IPersonajeService personajeService;
	
	@GetMapping
	@JsonView(PersonajeParcialModel.class)
	public ResponseEntity<List<PersonajeModel>>get(@RequestParam(name="name", required = false, defaultValue= "") String name,
			@RequestParam(name="age", required = false, defaultValue= "") String age,
			@RequestParam(name="weight", required = false, defaultValue= "") String weight,
			@RequestParam(name="movies", required = false, defaultValue= "") String idMovie){
		
		List<PersonajeModel>personajes = new ArrayList<PersonajeModel>();
		
		if(!name.isBlank() && age.isBlank() && weight.isBlank() && idMovie.isBlank())
			personajes.add(personajeService.findByNombre(name));
		if(name.isBlank() && !age.isBlank() && weight.isBlank() && idMovie.isBlank())
			personajes = personajeService.findByEdad(Integer.valueOf(age));
		if(name.isBlank() && age.isBlank() && !weight.isBlank() && idMovie.isBlank())
			personajes = personajeService.findByPeso(Double.valueOf(weight));
		if(name.isBlank() && age.isBlank() && weight.isBlank() && !idMovie.isBlank())
			//personajes = personajeService.findByIdMovie(Integer.valueOf(weight));
			System.out.println("TODO");
		if(name.isBlank() && age.isBlank() && weight.isBlank() && idMovie.isBlank())
			personajes = personajeService.getAll();
		
		return new ResponseEntity<List<PersonajeModel>>(personajes,HttpStatus.OK);
	}
	
	@GetMapping(value="image", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<ByteArrayResource> imagen() throws IOException{
		final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(("src/main/resources/static/imagenes/peliculas/loveRosie.jpg"))));
		System.out.println(inputStream.getFilename());
		return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
	}
	
	@PostMapping
	public ResponseEntity<PersonajeModel>create(@RequestBody PersonajeModel personaje){
		return new ResponseEntity<PersonajeModel>(personajeService.insertOrUpdate(personaje),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PersonajeModel>update(@RequestBody PersonajeModel pelicula){
		return new ResponseEntity<PersonajeModel>(personajeService.insertOrUpdate(pelicula),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PersonajeModel>info(@PathVariable("id") int id){
		PersonajeModel personaje = personajeService.findById(id);
		return new ResponseEntity<PersonajeModel>(personaje,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean>delete(@PathVariable("id") int id){
		return new ResponseEntity<Boolean>(personajeService.remove(id),HttpStatus.NO_CONTENT);
	}
	
}
