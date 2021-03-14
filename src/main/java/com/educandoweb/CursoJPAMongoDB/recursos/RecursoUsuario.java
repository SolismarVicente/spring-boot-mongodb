package com.educandoweb.CursoJPAMongoDB.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
import com.educandoweb.CursoJPAMongoDB.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarTodos() {
		//Usuario usuario1 = new Usuario("1", "Maria Brown", "maria@gmail.com");
		//Usuario usuario2 = new Usuario("2", "Alex Green", "alex@gmail.com");
		
		List<Usuario> lista = servicoUsuario.listarTodos();
		//lista.addAll(Arrays.asList(usuario1, usuario2));
		
		return ResponseEntity.ok().body(lista);
	}
}
