package br.com.helpetecnologia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.domain.Produto;
import br.com.helpetecnologia.repositories.CategoriaRepository;
import br.com.helpetecnologia.repositories.ClienteRepository;
import br.com.helpetecnologia.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	public Produto buscarProdutoId(int id) {		
		Optional<Produto> produto = repo.findById(id);
		return produto.orElse(null);		
	}

}
