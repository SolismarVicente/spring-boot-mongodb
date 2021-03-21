package com.educandoweb.CursoJPAMongoDB.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;
import com.educandoweb.CursoJPAMongoDB.repositorios.RepositorioPost;
import com.educandoweb.CursoJPAMongoDB.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service
public class ServicoPost {
	
	@Autowired
	private RepositorioPost repoPost;
	
	public List<Post> listarTodos() {
		return repoPost.findAll();
	}
	
	public Post buscarPorCodigo(String codigo) {
		Optional<Post> objetoPost = repoPost.findById(codigo);
		
		return objetoPost.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encontrado"));
	}
	
	public Post inserir(Post objetoPost) {
		return repoPost.insert(objetoPost);
	}
	
	public void excluir(String codigo) {
		buscarPorCodigo(codigo);
		
		repoPost.deleteById(codigo);
	}
	
	public Post alterar(Post objetoPost) {
		Post newObjetoPost = buscarPorCodigo(objetoPost.getCodigo()); 
				
		atualizarDados(newObjetoPost, objetoPost);
		return repoPost.save(newObjetoPost);
	}
	
	private void atualizarDados(Post newObjetoPost, Post objetoPost) {
		newObjetoPost.setData(objetoPost.getData());
		newObjetoPost.setTitle(objetoPost.getTitle());
		newObjetoPost.setBody(objetoPost.getBody());
	}

//	public Post fromDTO(DTOPost objetoDTOPost) {
//		return new Post(objetoDTOPost.getCodigo(), objetoDTOPost.getNomePost(), objetoDTOPost.getEmailPost());
//	}
	
	public List<Post> buscarPorTitulo(String texto) {
		//return repoPost.findByTitleContainingIgnoreCase(texto);
		return repoPost.buscarPorTitulo(texto);
	}
	
}
