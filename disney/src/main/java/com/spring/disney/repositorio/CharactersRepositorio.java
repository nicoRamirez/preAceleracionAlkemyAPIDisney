package com.spring.disney.repositorio;





import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.disney.modelo.Character;


@Repository
public interface CharactersRepositorio extends CrudRepository<Character, Long>{

		ArrayList<Character> findByNombre(String name);
		
		ArrayList<Character> findByEdad(Integer edad);
		
		
		
		
		

}
