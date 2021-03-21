package com.educandoweb.CursoJPAMongoDB.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;
import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
import com.educandoweb.CursoJPAMongoDB.dto.DTOAutor;
import com.educandoweb.CursoJPAMongoDB.dto.DTOComentario;
import com.educandoweb.CursoJPAMongoDB.repositorios.RepositorioPost;
import com.educandoweb.CursoJPAMongoDB.repositorios.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repoUsuario;
	
	@Autowired
	private RepositorioPost repoPost;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//limpar a coleção do MongoDB
		repoUsuario.deleteAll();
		repoPost.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		repoUsuario.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", new DTOAutor(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new DTOAutor(maria));
		
		DTOComentario comentario1 = new DTOComentario("Boa viagem mano!", sdf.parse("21/03/2018"), new DTOAutor(alex));
		DTOComentario comentario2 = new DTOComentario("Aproveite!", sdf.parse("22/03/2018"), new DTOAutor(bob));
		DTOComentario comentario3 = new DTOComentario("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new DTOAutor(alex));
		
		post1.getComentarios().addAll(Arrays.asList(comentario1, comentario2));
		post2.getComentarios().addAll(Arrays.asList(comentario3));
		
		repoPost.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repoUsuario.save(maria);
	}

}
