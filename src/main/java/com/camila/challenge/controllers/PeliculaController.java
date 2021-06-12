package com.camila.challenge.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camila.challenge.entities.Pelicula;
import com.camila.challenge.services.IPeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	@Qualifier("peliculaService")
	private IPeliculaService peliculaService;
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> get (@RequestParam(name="name", required = false, defaultValue= "") String name,
			@RequestParam(name="genre", required = false, defaultValue= "") String genre,
			@RequestParam(name="order", required = false, defaultValue= "") String order){
		
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		
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
		
		return new ResponseEntity<List<Pelicula>>(peliculas,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pelicula>create(@RequestBody Pelicula pelicula){
		return new ResponseEntity<Pelicula>(peliculaService.insertOrUpdate(pelicula),HttpStatus.CREATED);
	}
	
	/* TODO
	@PutMapping(value="/{id}")
	public ResponseEntity<Pelicula>update(@PathVariable("idPelicula") int idPelicula,@RequestBody Pelicula pelicula ){
		Pelicula peliculaActualizada = peliculaService.findById(idPelicula);
		return new ResponseEntity<Pelicula>(peliculaService.insertOrUpdate(pelicula),HttpStatus.OK);
	}
	*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean>delete(@PathVariable("id") int idPelicula){
		return new ResponseEntity<Boolean>(peliculaService.remove(idPelicula),HttpStatus.NO_CONTENT);
	}

}
