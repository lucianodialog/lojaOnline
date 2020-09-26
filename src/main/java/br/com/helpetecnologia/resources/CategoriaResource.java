package br.com.helpetecnologia.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpetecnologia.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
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

}
