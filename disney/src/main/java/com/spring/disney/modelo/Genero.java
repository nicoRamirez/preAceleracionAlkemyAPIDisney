package com.spring.disney.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="genero")
public class Genero {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String nombre;
	
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="generoDePeliOSerie")
	private PeliculaOSerie generoDePeliOSerie ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	

	public PeliculaOSerie getGeneroDePeliOSerie() {
		return generoDePeliOSerie;
	}

	public void setGeneroDePeliOSerie(PeliculaOSerie generoDePeliOSerie) {
		this.generoDePeliOSerie = generoDePeliOSerie;
	}
	

	public Genero(Long id, String nombre, String imagen, PeliculaOSerie generoDePeliOSerie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.generoDePeliOSerie = generoDePeliOSerie;
	}

	public Genero() {
		super();
	}

	
	
	
	
}
