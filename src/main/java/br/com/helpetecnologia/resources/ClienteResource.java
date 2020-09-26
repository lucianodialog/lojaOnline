package br.com.helpetecnologia.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.services.CategoriaService;
import br.com.helpetecnologia.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarClientesId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Cliente cliente = service.buscaclienteId(id);
		return ResponseEntity.ok(cliente);
		 
	}

	
	
	
}
