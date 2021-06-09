package com.spring.disney.modelo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






@Entity
@Table(name="peliculaOSerie")
public class PeliculaOSerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String imagen;
	
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaDeCreacion;
	
	
	private Integer calificacion;
	
	@ManyToMany(fetch = FetchType.EAGER,targetEntity = Character.class,cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE
			, CascadeType.REFRESH})
	@JoinTable(name="peliculas_personajes", joinColumns= @JoinColumn(name="peliculas_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "personaje_id",referencedColumnName = "id"))
	@JsonIgnoreProperties(value = "peliculaOSeries")
	private Set<Character> personajes = new HashSet<Character>();

	@ManyToOne
	@JoinColumn(name="genero_id")
	private Genero genero ;

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Set<Character> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Character> personajes) {
		this.personajes = personajes;
	}

	public PeliculaOSerie(Long id, String imagen, String titulo, Date fechaDeCreacion, Integer calificacion,
			Set<Character> personajes) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.personajes = personajes;
	}

	public PeliculaOSerie() {
		super();
	}

	


	
}
