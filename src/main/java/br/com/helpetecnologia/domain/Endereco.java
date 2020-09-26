package br.com.helpetecnologia.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_endereco;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String numero;
	private Integer fk_cod_cliente;
	
	public Endereco() {
		
	}

	public Endereco(Integer cod_endereco, String cep, String rua, String bairro, String cidade, String uf,
			String numero, Integer fk_cod_cliente) {
		super();
		this.cod_endereco = cod_endereco;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.numero = numero;
		this.fk_cod_cliente = fk_cod_cliente;
	}

	public Integer getCod_endereco() {
		return cod_endereco;
	}

	public void setCod_endereco(Integer cod_endereco) {
		this.cod_endereco = cod_endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getFk_cod_cliente() {
		return fk_cod_cliente;
	}

	public void setFk_cod_cliente(Integer fk_cod_cliente) {
		this.fk_cod_cliente = fk_cod_cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_endereco == null) ? 0 : cod_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cod_endereco == null) {
			if (other.cod_endereco != null)
				return false;
		} else if (!cod_endereco.equals(other.cod_endereco))
			return false;
		return true;
	}
	
	

	
	

}
