package br.com.helpetecnologia.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer cod_pedido;
	private Integer numero_nf;
    private String data_solicitacao;
    private String status_pedido;
    
    //Não aceita itens repetidos
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();
	
    public Pedido() {
		
	}

	public Pedido(Integer cod_pedido, Integer numero_nf, String data_solicitacao, String status_pedido) {
		super();
		this.cod_pedido = cod_pedido;
		this.numero_nf = numero_nf;
		this.data_solicitacao = data_solicitacao;
		this.status_pedido = status_pedido;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Integer getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Integer cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public Integer getNumero_nf() {
		return numero_nf;
	}

	public void setNumero_nf(Integer numero_nf) {
		this.numero_nf = numero_nf;
	}

	public String getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(String data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}

	public String getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_pedido == null) ? 0 : cod_pedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (cod_pedido == null) {
			if (other.cod_pedido != null)
				return false;
		} else if (!cod_pedido.equals(other.cod_pedido))
			return false;
		return true;
	}



	
    
    

    
	
}
