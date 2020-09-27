package br.com.helpetecnologia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpetecnologia.domain.Telefone;
import br.com.helpetecnologia.services.TelefoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST CLIENTES")//Annotation do Swagger 
@CrossOrigin(origins="*")//Annotation do Swagger: Libera para acesso a todos os domínios
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
		
	
	@ApiOperation(value="Retorna uma lista de telefones")
	@GetMapping("/telefones")
	public List<Telefone> ListaTodosTelefones(){
		return service.ListaTodosTelefones();
	}
	

	
	
	
}
