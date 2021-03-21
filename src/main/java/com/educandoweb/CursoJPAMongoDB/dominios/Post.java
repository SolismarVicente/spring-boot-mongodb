package com.educandoweb.CursoJPAMongoDB.dominios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.educandoweb.CursoJPAMongoDB.dto.DTOAutor;
import com.educandoweb.CursoJPAMongoDB.dto.DTOComentario;

@Document
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	private Date data;
	private String title;
	private String body; //body: corpo
	private DTOAutor autor;
	
	private List<DTOComentario> comentarios = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(String codigo, Date data, String title, String body, DTOAutor autor) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.title = title;
		this.body = body;
		this.autor = autor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public DTOAutor getAutor() {
		return autor;
	}

	public void setAutor(DTOAutor autor) {
		this.autor = autor;
	}
	
	public List<DTOComentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<DTOComentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
