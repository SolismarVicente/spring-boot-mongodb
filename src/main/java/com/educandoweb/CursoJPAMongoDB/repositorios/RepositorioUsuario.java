package com.educandoweb.CursoJPAMongoDB.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {

}
