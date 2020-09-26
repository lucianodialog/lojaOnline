package br.com.helpetecnologia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.repositories.CategoriaRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
//A interface CommandLineRunner permite criar um método que é chamado quando a aplicação começa a rodar 	
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

@Override
public void run(String... args) throws Exception {

	Categoria cat1 = new Categoria(null, "Livros");
	Categoria cat2 = new Categoria(null, "Vídeo");
	
	categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	
	
	
}

}
