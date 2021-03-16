package com.educandoweb.CursoJPAMongoDB.dto;

import java.io.Serializable;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;

public class DTOUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nomeUsuario;
	private String emailUsuario;
	
	public DTOUsuario() {
		
	}
	
	public DTOUsuario(Usuario objetoUsuario) {
		codigo = objetoUsuario.getCodigo();
		nomeUsuario = objetoUsuario.getNomeUsuario();
		emailUsuario = objetoUsuario.getEmailUsuario();
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

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	
}
