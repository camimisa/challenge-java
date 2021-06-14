package com.camila.challenge.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import com.camila.challenge.models.PeliculaModel;
import com.camila.challenge.models.PeliculaParcialModel;
import com.camila.challenge.models.PersonajeModel;
import com.camila.challenge.services.IPeliculaService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	@Qualifier("peliculaService")
	private IPeliculaService peliculaService;

	@GetMapping
	@JsonView(PeliculaParcialModel.class)
	public ResponseEntity<List<PeliculaModel>> get (@RequestParam(name="name", required = false, defaultValue= "") String name,
			@RequestParam(name="genre", required = false, defaultValue= "") String genre,
			@RequestParam(name="order", required = false, defaultValue= "") String order){
		
		List<PeliculaModel> peliculas = new ArrayList<PeliculaModel>();
		
		if(name.length() > 0 && genre.length() == 0 && order.length() == 0)
			peliculas.add(peliculaService.findByTitulo(name));
		if(name.length() == 0 && genre.length()>0 && order.length() == 0)
			peliculas = peliculaService.findAllByGenero(Integer.valueOf(genre));
		if(name.length() == 0 && genre.length()==0 && order.length()>0) {
			if(order.equalsIgnoreCase("ASC"))
				peliculas = peliculaService.findAllByFechaASC();
			if(order.equalsIgnoreCase("DESC"))
				peliculas = peliculaService.findAllByFechaDESC();
		}
		if(name.length()==0 && genre.length() == 0 && order.length() == 0)	
			peliculas = peliculaService.getAll();

		return new ResponseEntity<List<PeliculaModel>>(peliculas,HttpStatus.OK);
	}
	
	@GetMapping(value="image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<ByteArrayResource> imagen(@PathVariable("id") int id) throws IOException {
		final String path = "src/main/resources/static/imagenes/peliculas/";
		final String imageName = peliculaService.findById(id).getImagen();
		final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get((path + "" + imageName))));
		return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
	}
	
	@GetMapping(value="genre/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<ByteArrayResource> imagenGenero(@PathVariable("id") int id) throws IOException {
		final String path = "src/main/resources/static/imagenes/generos/";
		final String imageName = peliculaService.findById(id).getGenero().getImagen();
		final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get((path + "" + imageName))));
		return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
	}
	
	@PostMapping
	public ResponseEntity<PeliculaModel>create(@Valid @RequestBody PeliculaModel pelicula){
		return new ResponseEntity<PeliculaModel>(peliculaService.insertOrUpdate(pelicula),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PeliculaModel>update(@Valid @RequestBody PeliculaModel pelicula){
		return new ResponseEntity<PeliculaModel>(peliculaService.insertOrUpdate(pelicula),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeliculaModel>info(@PathVariable("id") int idPelicula){
		PeliculaModel pelicula = peliculaService.findById(idPelicula);
		return new ResponseEntity<PeliculaModel>(pelicula,HttpStatus.OK);
	}
	
	@PostMapping("/addCharacter/{id}")
	public ResponseEntity<Boolean>addCharacter(@Valid @RequestBody PersonajeModel personaje ,@PathVariable("id") int idPelicula){
		peliculaService.addCharacterToMovie(personaje, idPelicula);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@PostMapping("/addCharacter")
	public ResponseEntity<Boolean>addCharacter(@RequestParam(name="idMovie", required = true) int idPelicula, 
			@RequestParam(name="idCharacter", required = true) int idPersonaje){
		peliculaService.addCharacterToMovie(idPersonaje, idPelicula);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean>delete(@PathVariable("id") int idPelicula){
		return new ResponseEntity<Boolean>(peliculaService.remove(idPelicula),HttpStatus.NO_CONTENT);
	}

}
