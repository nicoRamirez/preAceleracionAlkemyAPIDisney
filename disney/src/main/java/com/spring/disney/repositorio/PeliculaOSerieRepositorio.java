package com.spring.disney.repositorio;




import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.spring.disney.modelo.PeliculaOSerie;


@Repository
public interface PeliculaOSerieRepositorio extends CrudRepository<PeliculaOSerie, Long> {

		ArrayList<PeliculaOSerie> findByTitulo(String titulo);
	
	
	
	
	

	
}
