package com.educandoweb.CursoJPAMongoDB.recursos;
//no vídeo está resources no lugar de recursos

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;
import com.educandoweb.CursoJPAMongoDB.recursos.util.URL;
import com.educandoweb.CursoJPAMongoDB.servicos.ServicoPost;

@RestController
@RequestMapping(value = "/posts")
public class RecursoPost {
	
	@Autowired
	private ServicoPost servicoPost;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<DTOAutor>> listarTodos() {
//		List<Post> lista = servicoPost.listarTodos();
//		
//		//converter a lista de Post para DTOAutor
//		List<DTOAutor> listaDTO = lista.stream().map(x -> new DTOAutor(x)).collect(Collectors.toList());
//		
//		return ResponseEntity.ok().body(listaDTO);
//	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Post> buscarPorCodigo(@PathVariable String codigo) {
		Post objetoPost = servicoPost.buscarPorCodigo(codigo);
		
		return ResponseEntity.ok().body(objetoPost);
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> inserir(@RequestBody DTOAutor objetoDTOPost) {
//		Post objetoPost = servicoPost.fromDTO(objetoDTOPost);
//		objetoPost = servicoPost.inserir(objetoPost);
//		
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(objetoPost.getCodigo()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
//	public ResponseEntity<DTOPost> excluir(@PathVariable String codigo) {
//		servicoPost.excluir(codigo);
//		
//		return ResponseEntity.noContent().build();
//	}
	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
//	public ResponseEntity<Void> alterar(@RequestBody DTOPost objetoDTOPost, @PathVariable String codigo) {
//		Post objetoPost = servicoPost.fromDTO(objetoDTOPost);
//		objetoPost.setCodigo(codigo);
//		objetoPost = servicoPost.alterar(objetoPost);
//		
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value = "/{codigo}/posts", method = RequestMethod.GET)
//	public ResponseEntity<List<Post>> buscarPorPost(@PathVariable String codigo) {
//		Post objetoPost = servicoPost.buscarPorCodigo(codigo);
//		
//		return ResponseEntity.ok().body(objetoPost.getPosts());
//	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscarPorTitulo(@RequestParam(value = "text", defaultValue = "") String texto) {
		texto = URL.decodificarParametro(texto);
		List<Post> lista = servicoPost.buscarPorTitulo(texto);
		
		return ResponseEntity.ok().body(lista);
	}
}
