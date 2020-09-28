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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;	
	
	@ApiOperation(value="Retorna uma única Categoria.")
	@RequestMapping(value="/categorias/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarCategoriasId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Categoria categoria = service.buscarCategoriaId(id);
		return ResponseEntity.ok(categoria);
		 
	}
	
	@ApiOperation(value="Insere uma nova Categoria.")
	@RequestMapping(value="/categorias/", method=RequestMethod.POST)
	public ResponseEntity<Void> inserirCategoria(@RequestBody Categoria categoria) {	
		categoria = service.insert(categoria);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualiza uma Categoria.")
	@RequestMapping(value="/categorias/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Integer id) {			
		categoria.setId(id);
		categoria = service.atualizarCategoria(categoria);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Deleta uma Categoria.")
	@RequestMapping(value="/categorias/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id) {
			service.deleteById(id);
		return ResponseEntity.noContent().build();//Retorna a resposta sem conteúdo 
	}
	
	@ApiOperation(value="Retorna uma Lista de Categorias.")
	@RequestMapping(value="/categorias/", method=RequestMethod.GET)
	public ResponseEntity<List<?>> listarTodasCategorias() {
		List<Categoria> lista_categorias = service.listarTodasCategorias();
		return ResponseEntity.ok().body(lista_categorias);
	}	
	
	
}
