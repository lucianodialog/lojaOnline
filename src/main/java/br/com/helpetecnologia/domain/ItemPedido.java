package br.com.helpetecnologia.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();	
	private Integer quantidade;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	@JsonIgnore
	//Permite acessar o pedido e produto fora da classes pedido e produto e melhorar a semântica da classe
	public Pedido getPedido() {
		return id.getPedido();
	}
	

	public Produto getProduto() {
		return id.getProduto();
	}
	
	
/*
	public Integer getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
