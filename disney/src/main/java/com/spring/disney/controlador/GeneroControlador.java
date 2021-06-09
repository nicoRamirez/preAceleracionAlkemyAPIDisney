package com.spring.disney.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.disney.modelo.Genero;
import com.spring.disney.servicio.GeneroServicio;


@RestController
@RequestMapping("/genero")
public class GeneroControlador {
	
	@Autowired
	GeneroServicio generoServicio;
	
	@GetMapping()
	public List<Genero> obtenerGeneros(){
		return generoServicio.obtenerGenero();
	}
	@PostMapping()
	public Genero guardarPersonaje(@RequestBody Genero genero) {
		return generoServicio.guardarGenero(genero);
		
	}
	
}
