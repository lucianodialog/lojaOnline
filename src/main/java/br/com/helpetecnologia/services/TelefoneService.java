package br.com.helpetecnologia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Telefone;
import br.com.helpetecnologia.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository repo;
	
	public List<Telefone> ListaTodosTelefones() {		
		 List<Telefone> telefones = repo.findAll();
		 return telefones;		
	}	

	
	public Telefone buscarTelefoneId(int id) {		
		Optional<Telefone> telefone = repo.findById(id);
		return telefone.orElse(null);		
	}

}
