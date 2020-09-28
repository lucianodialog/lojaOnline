package br.com.helpetecnologia.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.services.CategoriaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> ListarCategorias() {
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");		
		List<Categoria> lista_categorias = new ArrayList<>();
		lista_categorias.add(cat1);
		lista_categorias.add(cat2);
		return lista_categorias;				
		//return "Chamou categorias";
		 
	}
	
	*/
	
	@RequestMapping(value="/categorias/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarCategoriasId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Categoria categoria = service.buscarCategoriaId(id);
		return ResponseEntity.ok(categoria);
		 
	}
	
	@RequestMapping(value="/categorias/", method=RequestMethod.POST)
	public ResponseEntity<Void> inserirCategoria(@RequestBody Categoria categoria) {	
		categoria = service.insert(categoria);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
}
