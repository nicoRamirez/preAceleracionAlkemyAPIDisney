package com.spring.disney.servicio;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.disney.modelo.PeliculaOSerie;
import com.spring.disney.modelo.PeliculasOSerieDTO;
import com.spring.disney.repositorio.PeliculaOSerieRepositorio;

@Service
public class PeliculaOSerieServicio {

	@Autowired
	PeliculaOSerieRepositorio peliculaOSerieRepositorio;

	public PeliculasOSerieDTO obtenerPeliculaOSerieDTOPorId(Long id) {
		Optional<PeliculaOSerie> peliculaOSerie = peliculaOSerieRepositorio.findById(id);
		if (peliculaOSerie != null && peliculaOSerie.isPresent()) {
			PeliculasOSerieDTO dto = new PeliculasOSerieDTO();
			dto.setImagen(peliculaOSerie.get().getImagen());
			dto.setTitulo(peliculaOSerie.get().getTitulo());
			dto.setFechaDeCreacion(peliculaOSerie.get().getFechaDeCreacion());
			return dto;
		}
		return null;
	}

	public List<PeliculasOSerieDTO> obtenerImagenTituloFechaPeliculaOSerie() {
		List<PeliculaOSerie> listaPelicula = (ArrayList<PeliculaOSerie>) peliculaOSerieRepositorio.findAll();
		List<PeliculasOSerieDTO> dto = new ArrayList<PeliculasOSerieDTO>();
		for (PeliculaOSerie elemento : listaPelicula) {
			dto.add(this.obtenerPeliculaOSerieDTOPorId(elemento.getId()));
		}
		return dto;
	}

	public PeliculaOSerie guardarPeliculaOSerie(PeliculaOSerie peliculaOSerie) {

		return peliculaOSerieRepositorio.save(peliculaOSerie);
	}

	public String eliminarCharacter(Long id) {
		try {
			peliculaOSerieRepositorio.deleteById(id);
			return "se elimino a la pelicula con id " + id;
		} catch (Exception error) {
			return "no se encontro ninguna pelicula con esa id, por favor ingrese un id exitente";
		}

	}

	public String modificaCharacter(PeliculaOSerie peliculaOSerie) {
		if (peliculaOSerieRepositorio.existsById(peliculaOSerie.getId())) {
			peliculaOSerieRepositorio.save(peliculaOSerie);
			return "se modifico la pelicula con id " + peliculaOSerie.getId();
		}
		return "no se puedo modificar la pelicula porque no se encontro en la base de datos intente de nuevo";
	}

	public Optional<PeliculaOSerie> obtenerPeliculaPorId(Long id) {
		return peliculaOSerieRepositorio.findById(id);

	}

	public ArrayList<PeliculaOSerie> peliculaEncontrada(String name) {
		if(name != null) {
			return peliculaOSerieRepositorio.findByTitulo(name);
		}
		return null;

	}

}