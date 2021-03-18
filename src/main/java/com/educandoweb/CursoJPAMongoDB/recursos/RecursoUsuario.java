package com.educandoweb.CursoJPAMongoDB.recursos;
//no vídeo está resources no lugar de recursos

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
import com.educandoweb.CursoJPAMongoDB.dto.DTOUsuario;
import com.educandoweb.CursoJPAMongoDB.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DTOUsuario>> listarTodos() {
		//Usuario usuario1 = new Usuario("1", "Maria Brown", "maria@gmail.com");
		//Usuario usuario2 = new Usuario("2", "Alex Green", "alex@gmail.com");
		
		List<Usuario> lista = servicoUsuario.listarTodos();
		//lista.addAll(Arrays.asList(usuario1, usuario2));
		
		//converter a lista de Usuario para DTOUsuario
		List<DTOUsuario> listaDTO = lista.stream().map(x -> new DTOUsuario(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<DTOUsuario> buscarPorCodigo(@PathVariable String codigo) {
		Usuario objetoUsuario = servicoUsuario.buscarPorCodigo(codigo);
		
		return ResponseEntity.ok().body(new DTOUsuario(objetoUsuario));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody DTOUsuario objetoDTOUsuario) {
		Usuario objetoUsuario = servicoUsuario.fromDTO(objetoDTOUsuario);
		objetoUsuario = servicoUsuario.inserir(objetoUsuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(objetoUsuario.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<DTOUsuario> excluir(@PathVariable String codigo) {
		servicoUsuario.excluir(codigo);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody DTOUsuario objetoDTOUsuario, @PathVariable String codigo) {
		Usuario objetoUsuario = servicoUsuario.fromDTO(objetoDTOUsuario);
		objetoUsuario.setCodigo(codigo);
		objetoUsuario = servicoUsuario.alterar(objetoUsuario);
		
		return ResponseEntity.noContent().build();
	}
}
