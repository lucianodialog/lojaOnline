package br.com.helpetecnologia.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cod_telefone;
    private char ddd;
    private String numero_telefone;
    
    @JsonBackReference//Significa, do outro lado da associação já foram buscado os objetos, então agora eu não busco mais.    
    @ManyToOne
	@JoinColumn(name="fk_cliente")
    private Cliente cliente; 
    
    
    
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Telefone() {
    	
    }

	public Telefone(Integer cod_telefone, char ddd, String numero_telefone, Integer fk_cliente) {
		super();
		this.cod_telefone = cod_telefone;
		this.ddd = ddd;
		this.numero_telefone = numero_telefone;
		
	}

	public Integer getCod_telefone() {
		return cod_telefone;
	}

	public void setCod_telefone(Integer cod_telefone) {
		this.cod_telefone = cod_telefone;
	}

	public char getDdd() {
		return ddd;
	}

	public void setDdd(char ddd) {
		this.ddd = ddd;
	}

	public String getNumero_telefone() {
		return numero_telefone;
	}

	public void setNumero_telefone(String numero_telefone) {
		this.numero_telefone = numero_telefone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_telefone == null) ? 0 : cod_telefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (cod_telefone == null) {
			if (other.cod_telefone != null)
				return false;
		} else if (!cod_telefone.equals(other.cod_telefone))
			return false;
		return true;
	}
    
    

}
