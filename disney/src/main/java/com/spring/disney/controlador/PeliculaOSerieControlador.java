package com.spring.disney.controlador;




import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.disney.modelo.PeliculaOSerie;
import com.spring.disney.modelo.PeliculasOSerieDTO;
import com.spring.disney.servicio.PeliculaOSerieServicio;

@RestController
@RequestMapping("/movie")
public class PeliculaOSerieControlador {

	@Autowired
	PeliculaOSerieServicio peliculaOSerieServicio;
	
	
	@PostMapping(value = "/guardar")
	public PeliculaOSerie guardarPeliculaOSerie(@RequestBody PeliculaOSerie peliculaOSerie) {
		return peliculaOSerieServicio.guardarPeliculaOSerie(peliculaOSerie);
		
	}
	@GetMapping
	public List<PeliculasOSerieDTO> obtenerPeliculaOSerie() {
		return peliculaOSerieServicio.obtenerImagenTituloFechaPeliculaOSerie();
	}
	
	@DeleteMapping(path ="/eliminar/{id}")
	public String eliminarPeliculaPorId(@PathVariable("id")Long id) {
		return peliculaOSerieServicio.eliminarCharacter(id);
	}
	
	@PutMapping(value = "/modificar") 
	public String modificarPelicula(@RequestBody PeliculaOSerie pelicula) {
		return peliculaOSerieServicio.modificaCharacter(pelicula);
		
	}
	@GetMapping(path = "/buscar/{id}")
	public Optional<PeliculaOSerie> obtenerpeliculaPorId(@PathVariable Long id) {
		return peliculaOSerieServicio.obtenerPeliculaPorId(id);
		
		
	}
	@GetMapping(path =  "/movies")
	public ArrayList<PeliculaOSerie> obtenerPeliculaPorParametro(@RequestParam(value = "name")
	String name
			) {
		return peliculaOSerieServicio.peliculaEncontrada(name);
	}
	
}
