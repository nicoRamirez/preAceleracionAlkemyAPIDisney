package com.spring.disney.servicio;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.disney.modelo.Character;
import com.spring.disney.modelo.CharacterDTO;
import com.spring.disney.repositorio.CharactersRepositorio;

@Service
public class CharactersServicio {

	@Autowired
	CharactersRepositorio charactersRepositorio;



	// devuelve una lista de todos los personajes ingresados pero mostrando solos
	// los atributos imagen y nombre
	public List<CharacterDTO> obtenerImagenNombreCharacters() {
		List<Character> listaCaracter = (ArrayList<Character>) charactersRepositorio.findAll();
		List<CharacterDTO> dto = new ArrayList<CharacterDTO>();
		for (Character elemento : listaCaracter) {
			dto.add(this.obtenerCharacterDTOPorId(elemento.getId()));
		}
		return dto;
	}

	// devuelve un personaje de tipo character en el cual solamente muestra su
	// imagen y nombre
	public CharacterDTO obtenerCharacterDTOPorId(Long id) {
		Optional<Character> character = charactersRepositorio.findById(id);
		if (character != null && character.isPresent()) {
			CharacterDTO dto = new CharacterDTO();
			dto.setImagen(character.get().getImagen());
			dto.setNombre(character.get().getNombre());
			return dto;
		}
		return null;
	}

	// guarda un personaje de tipo character en la base de datos
	public Character guardarCharacter(Character personaje) {
		
		return charactersRepositorio.save(personaje);
	}
	
	//elimina al character con el cual tiene determinado el id que se envia por parametro
	public String eliminarCharacter(Long id) {
		try{
            charactersRepositorio.deleteById(id);
            return "se elimino al personaje con id "+id;
        }catch(Exception error){
            return "no se encontro ningun personaje con esa id, por favor ingrese un id exitente";
        }
		
	}
	// modifica al character si lo encuentra por el id y devueve verdadero, en caso contrario devuelve falso
	public String modificaCharacter(Character character) {
		if(charactersRepositorio.existsById(character.getId())) {
			charactersRepositorio.save(character);
			return "se modifico el personaje con id "+ character.getId();
		}
		return "no se puedo modificar el personaje porque no se encontro en la base de datos intente de nuevo";
	}
	
	public ArrayList<Character> characterEncontrado(String name, Integer edad) {
			if(name != null) {
				if(edad != null) {
					return charactersRepositorio.findByEdad(edad);
				}
				return charactersRepositorio.findByNombre(name);
			}
			else {
				if(edad != null) {
					return charactersRepositorio.findByEdad(edad);
					
				}
				
					return null;
				}
			}
			
			
	
			

	 
			public Optional<Character> obtenerCharacterPorId(Long id) {
				return charactersRepositorio.findById(id);
			}
		
		
	}



