package it.simpleAngular.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MetodoPagamento")
public class MetodoPagamento {

	@Id
	@Column(name = "idmetodopagamento")
	@GeneratedValue
	Integer idMetodoPagamento;
	
	@Column(name="importo", length = 100)
	@NotNull
	String nomeMetodo;

	public Integer getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	public void setIdMetodoPagamento(Integer idMetodoPagamento) {
		this.idMetodoPagamento = idMetodoPagamento;
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public void setNomeMetodo(String nomeMetodo) {
		this.nomeMetodo = nomeMetodo;
	}
	
	
}
