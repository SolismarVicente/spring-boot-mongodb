package com.educandoweb.CursoJPAMongoDB.dto;

import java.io.Serializable;
import java.util.Date;

public class DTOComentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date dataComentario;
	private DTOAutor autor;
	
	public DTOComentario() {
		
	}

	public DTOComentario(String texto, Date dataComentario, DTOAutor autor) {
		super();
		this.texto = texto;
		this.dataComentario = dataComentario;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}

	public DTOAutor getAutor() {
		return autor;
	}

	public void setAutor(DTOAutor autor) {
		this.autor = autor;
	}
	
}
