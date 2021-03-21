package com.educandoweb.CursoJPAMongoDB.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } } ")
	List<Post> buscarPorTitulo(String texto);
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
}
