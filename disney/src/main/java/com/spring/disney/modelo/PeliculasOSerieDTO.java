package com.spring.disney.modelo;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
@Entity

public class PeliculasOSerieDTO {
	
	@Id
	private String imagen;
	private String titulo;
	
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaDeCreacion;
	
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
	public PeliculasOSerieDTO(String imagen, String titulo, Date fechaDeCreacion) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
	}
	public PeliculasOSerieDTO() {
		super();
	}

	
	

	

	

	

	

}
