package com.educandoweb.CursoJPAMongoDB.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
import com.educandoweb.CursoJPAMongoDB.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repoUsuario;
	
	public List<Usuario> listarTodos() {
		return repoUsuario.findAll();
	}
}
