package com.spring.disney.modelo;

import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CharacterDTO {
	
	
	
	@Id
	private String imagen;
	
	
	private String nombre;


	


	public String getImagen() {
		return imagen;
	}


	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public CharacterDTO(String imagen, String nombre) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
	}



	public CharacterDTO() {
		super();
	}


	



	
}
