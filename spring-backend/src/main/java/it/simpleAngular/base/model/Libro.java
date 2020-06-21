package it.simpleAngular.base.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "LIBRI")
public class Libro {
	@Id
	@Column(name = "IDLIBRO")
	@GeneratedValue
	int idLibro;
	@Column(name = "NAME", length = 150)
	@NotNull
	String nome;
	@Column(name = "TITOLOCOMPLETO", length = 450)
	@NotNull
	String titoloCompleto;
	@Column(name = "ANNO")
	@NotNull
	int anno;
	@Column(name = "ISBN", length = 150)
	@NotNull
	String isbn;
	@Column(name = "PUNTEGGIO")
	Double punteggio;
	@Column(name = "PREZZO")
	Double prezzo;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="libro")
	//@Column(name="recensioni")
	List<Recensione> listaRecensioni ;
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTitoloCompleto() {
		return titoloCompleto;
	}
	public void setTitoloCompleto(String titoloCompleto) {
		this.titoloCompleto = titoloCompleto;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(Double punteggio) {
		this.punteggio = punteggio;
	}
	public List<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}
	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Libro() {
		super();
	}

}
