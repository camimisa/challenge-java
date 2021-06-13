package com.camila.challenge.converters;

import org.springframework.stereotype.Component;

import com.camila.challenge.entities.Genero;
import com.camila.challenge.models.GeneroModel;

@Component("generoConverter")
public class GeneroConverter {

	public GeneroModel entidadAModelo(Genero genero) {
		return new GeneroModel(genero.getIdGenero(), genero.getNombre(), genero.getImage());
	}
	
	public Genero modeloAEntidad(GeneroModel generoModel) {
		return new Genero(generoModel.getIdGenero(), generoModel.getNombre(), generoModel.getImage());
	}
}
