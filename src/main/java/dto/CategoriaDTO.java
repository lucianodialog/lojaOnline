package dto;



import java.io.Serializable;

import br.com.helpetecnologia.domain.Categoria;
//import javax.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
public CategoriaDTO(Categoria cat) {
		this.id = cat.getId();
		this.nome = cat.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}