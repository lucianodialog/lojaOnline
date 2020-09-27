package br.com.helpetecnologia.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpetecnologia.domain.Pedido;
import br.com.helpetecnologia.services.PedidoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<Pedido> ListarPedidos() {
		
		Pedido cat1 = new Pedido(1, "Informática");
		Pedido cat2 = new Pedido(2, "Escritório");		
		List<Pedido> lista_categorias = new ArrayList<>();
		lista_categorias.add(cat1);
		lista_categorias.add(cat2);
		return lista_categorias;				
		//return "Chamou categorias";
		 
	}
	
	*/
	
	@RequestMapping(value="pedidos/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarPedidosId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Pedido pedido = service.buscarPedidoId(id);
		return ResponseEntity.ok(pedido);
		 
	}

	
	
	
}
