package br.com.helpetecnologia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Pedido;
import br.com.helpetecnologia.repositories.PedidoRepository;
import br.com.helpetecnologia.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	/*
	public Pedido buscarPedidoId(int id) {		
		Optional<Pedido> categoria = repo.findById(id);
		return categoria.orElse(null);		
	}
	*/
	
	public Pedido buscarPedidoId(int id) {		
		Optional<Pedido> pedido = repo.findById(id);	
			return pedido.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));	
	
	}

}
