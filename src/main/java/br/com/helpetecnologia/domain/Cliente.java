package br.com.helpetecnologia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_cliente;
	private String nome;
	private String cpf;
	private Date data_nacimento;	
	
	//@JsonBackReference
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	@OneToMany(mappedBy="cliente")	
	private List<Endereco> enderecos = new ArrayList<>();
	//@ElementCollection
	//CollectionTable(name="")
	//private Set<String> telefone = new HashSet<>();
	
	//@JsonManagedReference Evita referência cíclica e colocada aqui do lado que eu quero trazer os telefones de cada cliente
	//@JsonManagedReference
	//
	@OneToMany(mappedBy="cliente")	
	private List<Telefone> telefones = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "cliente")
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Cliente() {
		
	}

	public Cliente(Integer cod_cliente, String nome, String cpf, Date data_nacimento) {
		super();
		this.cod_cliente = cod_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nacimento = data_nacimento;
	}

	public Integer getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nacimento() {
		return data_nacimento;
	}

	public void setData_nacimento(Date data_nacimento) {
		this.data_nacimento = data_nacimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_cliente == null) ? 0 : cod_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cod_cliente == null) {
			if (other.cod_cliente != null)
				return false;
		} else if (!cod_cliente.equals(other.cod_cliente))
			return false;
		return true;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	
	

}
