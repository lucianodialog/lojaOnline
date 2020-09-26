package br.com.helpetecnologia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public Categoria buscarCategoriaId(int id) {		
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElse(null);		
	}

}
