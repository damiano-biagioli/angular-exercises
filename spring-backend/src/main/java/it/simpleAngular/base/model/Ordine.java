package it.simpleAngular.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDINI")
public class Ordine {

	
	@Id
	@Column(name = "idordine")
	@GeneratedValue
	Integer idOrdine;
	
	@Column(name="importo")
	@NotNull
	Double importo;
	
	@Column(name="eseguito")
	@NotNull	
	int eseguito;
	
	@ManyToOne
    @JoinColumn(name="IDLIBRO", nullable=false)
    Libro libro;
	
	@ManyToOne
    @JoinColumn(name="idmetodopagamento", nullable=false)
    MetodoPagamento metodoPagamento;
	
	@ManyToOne
    @JoinColumn(name="username", nullable=false)
    User user;

	public Integer getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public int getEseguito() {
		return eseguito;
	}

	public void setEseguito(int eseguito) {
		this.eseguito = eseguito;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
