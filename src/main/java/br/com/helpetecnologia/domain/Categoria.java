package br.com.helpetecnologia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_categoria;
	private String nome;	
	
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	
	//Tem que ter o construtor padrão. Se não dár erro ao chamar o endpoint Categoria
	public Categoria() {
		
	}	

	public Categoria(Integer id, String nome) {
		super();
		this.cod_categoria = id;
		this.nome = nome;
	}

	public Integer getId() {
		return cod_categoria;
	}

	public void setId(Integer id) {
		this.cod_categoria = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	


	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_categoria == null) ? 0 : cod_categoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cod_categoria == null) {
			if (other.cod_categoria != null)
				return false;
		} else if (!cod_categoria.equals(other.cod_categoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + cod_categoria + ", nome=" + nome + "]";
	}
	
	

}
