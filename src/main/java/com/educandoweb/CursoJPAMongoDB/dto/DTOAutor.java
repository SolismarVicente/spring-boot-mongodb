package com.educandoweb.CursoJPAMongoDB.dto;

import java.io.Serializable;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;

public class DTOAutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nomeUsuario;
	
	public DTOAutor() {
		
	}
	
	public DTOAutor(Usuario objetoUsuario) {
		codigo = objetoUsuario.getCodigo();
		nomeUsuario = objetoUsuario.getNomeUsuario();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
}
