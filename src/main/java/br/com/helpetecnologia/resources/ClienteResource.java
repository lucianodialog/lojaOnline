package br.com.helpetecnologia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="clientes/{id}", method=RequestMethod.GET)
	@ApiOperation(value="Busca um Cliente por Id")//Annotation do Swagger:
	public ResponseEntity<?> ListarClientesId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Cliente cliente = service.buscaClienteId(id);
		return ResponseEntity.ok(cliente);
		 
	}
	
	@ApiOperation(value="Retorna uma lista de clientes")
	@GetMapping("/clientes")
	public List<Cliente> ListaTodosClientes(){
		return service.ListaTodosClientes();
	}
	
}
