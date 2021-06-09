package com.spring.disney.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.disney.modelo.Genero;
import com.spring.disney.repositorio.GeneroRepositorio;

@Service
public class GeneroServicio {
	@Autowired
	GeneroRepositorio generoRepositorio;
	
	public List<Genero> obtenerGenero() {
		return (List<Genero>) generoRepositorio.findAll();
	}

	public Genero guardarGenero(Genero genero) {
		
		return generoRepositorio.save(genero);
	}
	
}
