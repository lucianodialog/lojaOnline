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
import br.com.helpetecnologia.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> ListarCategorias() {
		/*
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");		
		List<Categoria> lista_categorias = new ArrayList<>();
		lista_categorias.add(cat1);
		lista_categorias.add(cat2);
		return lista_categorias;				
		//return "Chamou categorias";
		 
	}
	*/
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> ListarCategoriasId(@PathVariable Integer id) {
		//o retorno ResponseEntity<T> e um tipo espeical que retorna todas as informações da requisição
		//ResponseEntity<?>. A interrogação significa qualquer tipo
		Categoria categoria = service.buscarCategoria(id);
		return ResponseEntity.ok(categoria);
		 
	}

	
	
	
}
