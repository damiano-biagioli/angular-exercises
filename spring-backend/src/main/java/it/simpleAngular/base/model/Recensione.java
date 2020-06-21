package it.simpleAngular.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="RECENSIONI")
public class Recensione {

	@Id
	@Column(name = "idrecensione")
	@GeneratedValue
	Integer idRecensione;
	
	@Column(name = "TESTO")
	@Type(type="text")
	String testo;
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="IDLIBRO", nullable=false)
    Libro libro;
	
	@ManyToOne
    @JoinColumn(name="username", nullable=false)
    User user;

	public Integer getIdRecensione() {
		return idRecensione;
	}

	public void setIdRecensione(Integer idRecensione) {
		this.idRecensione = idRecensione;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
