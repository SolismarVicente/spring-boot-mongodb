package com.educandoweb.CursoJPAMongoDB.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {

}
