package br.com.helpetecnologia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	public List<Cliente> ListaTodosClientes() {		
		 List<Cliente> cliente = repo.findAll();
		 return cliente;		
	}	

	
	public Cliente buscaClienteId(int id) {		
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElse(null);		
	}




}
