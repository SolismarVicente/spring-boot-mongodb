package com.educandoweb.CursoJPAMongoDB.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.CursoJPAMongoDB.dominios.Post;
import com.educandoweb.CursoJPAMongoDB.dominios.Usuario;
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		repoUsuario.saveAll(Arrays.asList(maria, alex, bob));
		repoPost.saveAll(Arrays.asList(post1, post2));
	}

}
