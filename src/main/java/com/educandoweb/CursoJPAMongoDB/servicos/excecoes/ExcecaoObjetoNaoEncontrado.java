package com.educandoweb.CursoJPAMongoDB.servicos.excecoes;

//no vídeo está ObjectNotFoundException
public class ExcecaoObjetoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcecaoObjetoNaoEncontrado(String msg) {
		super(msg);
	}
}
