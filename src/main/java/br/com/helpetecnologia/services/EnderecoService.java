package br.com.helpetecnologia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.domain.Endereco;
import br.com.helpetecnologia.repositories.CategoriaRepository;
import br.com.helpetecnologia.repositories.ClienteRepository;
import br.com.helpetecnologia.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repo;
	
	public Endereco buscarEnderecoId(int id) {		
		Optional<Endereco> endereco = repo.findById(id);
		return endereco.orElse(null);		
	}

}
