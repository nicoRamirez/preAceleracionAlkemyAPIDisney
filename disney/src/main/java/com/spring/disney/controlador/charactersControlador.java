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

import com.spring.disney.modelo.Character;
import com.spring.disney.modelo.CharacterDTO;
import com.spring.disney.servicio.CharactersServicio;


@RestController
@RequestMapping("/characters")
public class charactersControlador {
	
	@Autowired
	CharactersServicio characterServicio;
	
	//devuelve toda la lista de  character en json mostrando solo imagen y nombre usando la funcion del charactersServicio
	@GetMapping(value="")
	public List<CharacterDTO> obtenerCharacters(){
		return characterServicio.obtenerImagenNombreCharacters();
	}
	
	//guarda al personaje en la bases de datos usando el metodo de guardar del charactersServicio
	@PostMapping(value = "/guardar")
	public Character guardarCharacter(@RequestBody Character personaje) {
		return characterServicio.guardarCharacter(personaje);
		
	}
	//devuelve por medio de un id al personaje que devuelve que se pasa por parametro 
	@GetMapping(path = "/buscar/{id}")
	public Optional<Character> obtenerCharacterPorId(@PathVariable Long id) {
		return characterServicio.obtenerCharacterPorId(id);
	}
	
	//elimina el character por medio de un numeri id que se manda por parametro
	@DeleteMapping(path ="/eliminar/{id}")
	public String eliminarCharacterPorId(@PathVariable("id")Long id) {
		return characterServicio.eliminarCharacter(id);
	}
	//devuelve un mensaje que se modifico al character si lo pudo hacer , en caso cotrario devuelve un mensaje
	//en donde dice que no lo pudo modificar
	@PutMapping(value = "/modificar") 
	public String modificarCharacter(@RequestBody Character personaje) {
		return characterServicio.modificaCharacter(personaje);
		
	}
	
	
	
	@GetMapping(path =  "/character")
	public ArrayList<Character> obtenerCharacterPorParametro(@RequestParam(value = "name") String name,@RequestParam(value = "edad")Integer edad
			) {
		return characterServicio.characterEncontrado(name,edad);
	}
	
	
	
	
}
