package com.educandoweb.CursoJPAMongoDB.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
import com.educandoweb.CursoJPAMongoDB.dto.DTOUsuario;
import com.educandoweb.CursoJPAMongoDB.repositorios.RepositorioUsuario;
import com.educandoweb.CursoJPAMongoDB.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repoUsuario;
	
	public List<Usuario> listarTodos() {
		return repoUsuario.findAll();
	}
	
	public Usuario buscarPorCodigo(String codigo) {
		Optional<Usuario> objetoUsuario = repoUsuario.findById(codigo);
		
		return objetoUsuario.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encontrado"));
	}
	
	public Usuario inserir(Usuario objetoUsuario) {
		return repoUsuario.insert(objetoUsuario);
	}
	
	public void excluir(String codigo) {
		buscarPorCodigo(codigo);
		
		repoUsuario.deleteById(codigo);
	}
	
	public Usuario alterar(Usuario objetoUsuario) {
		Usuario newObjetoUsuario = buscarPorCodigo(objetoUsuario.getCodigo()); 
				
		atualizarDados(newObjetoUsuario, objetoUsuario);
		return repoUsuario.save(newObjetoUsuario);
	}
	
	private void atualizarDados(Usuario newObjetoUsuario, Usuario objetoUsuario) {
		newObjetoUsuario.setNomeUsuario(objetoUsuario.getNomeUsuario());
		newObjetoUsuario.setEmailUsuario(objetoUsuario.getEmailUsuario());
	}

	public Usuario fromDTO(DTOUsuario objetoDTOUsuario) {
		return new Usuario(objetoDTOUsuario.getCodigo(), objetoDTOUsuario.getNomeUsuario(), objetoDTOUsuario.getEmailUsuario());
	}
}
