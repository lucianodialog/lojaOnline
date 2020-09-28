package br.com.helpetecnologia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_produto;
	private String nome;
	private float preco;
	private String descricao;
	private int qtda_estoque;	
	
	  @JsonIgnore
	 @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();
	
	//@JsonBackReference //Quer dizer: Olha do outro lado da referência eu busco os objetos, e desse lado eu não busco mais
	  @JsonIgnore
	@ManyToMany
	@JoinTable(name="PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name="cod_produto"), inverseJoinColumns = @JoinColumn(name = "cod_categoria"))
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
		
	}

	public Produto(Integer cod_produto, String nome, float preco, String descricao, int qtda_estoque) {
		super();
		this.cod_produto = cod_produto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.qtda_estoque = qtda_estoque;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for(ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	
	
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Integer getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtda_estoque() {
		return qtda_estoque;
	}

	public void setQtda_estoque(int qtda_estoque) {
		this.qtda_estoque = qtda_estoque;
	}
	
	

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_produto == null) ? 0 : cod_produto.hashCode());
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
		Produto other = (Produto) obj;
		if (cod_produto == null) {
			if (other.cod_produto != null)
				return false;
		} else if (!cod_produto.equals(other.cod_produto))
			return false;
		return true;
	}

	

	
	
	

	
}
