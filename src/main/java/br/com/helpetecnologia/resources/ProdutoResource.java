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

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.domain.Produto;
import br.com.helpetecnologia.services.CategoriaService;
import br.com.helpetecnologia.services.ClienteService;
import br.com.helpetecnologia.services.ProdutoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="produtos/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarProdutoId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Produto produto = service.buscarProdutoId(id);
		return ResponseEntity.ok(produto);
		 
	}
	
}
