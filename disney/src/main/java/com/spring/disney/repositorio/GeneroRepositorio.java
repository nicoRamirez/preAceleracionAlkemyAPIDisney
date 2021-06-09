package com.spring.disney.repositorio; 


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.disney.modelo.Genero;


@Repository
public interface GeneroRepositorio extends CrudRepository<Genero, Long> {

}
