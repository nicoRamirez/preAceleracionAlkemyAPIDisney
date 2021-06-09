package com.spring.disney.modelo;


import java.util.HashSet;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






@Entity
@Table(name="personaje")

public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	
	private String imagen;
	
	
	private String nombre;
	
	
	private Integer edad;
	
	
	private Double peso;
	
	@Column(length = 100)
	private String historia;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = PeliculaOSerie.class, mappedBy = "personajes", cascade = {CascadeType.PERSIST,
			CascadeType.DETACH,CascadeType.MERGE
			, CascadeType.REFRESH})
	@JsonIgnoreProperties(value = "personajes")
	private Set<PeliculaOSerie> peliculas = new HashSet<PeliculaOSerie>() ;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	
	public String getPeliculas() {
		
		return peliculas.toString();
	}


	public void setPeliculas(Set<PeliculaOSerie> peliculas) {
		this.peliculas = peliculas;
	}


	public Character(Long id, String imagen, String nombre, Integer edad, Double peso, String historia,
			Set<PeliculaOSerie> peliculas) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
	}


	public Character() {
		super();
	}


	


	


	


	
	


	


	

	

	
	
	
	
	
}
