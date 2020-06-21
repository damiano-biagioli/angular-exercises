package it.simpleAngular.base.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class RicercaLibro {
	int idLibro;
	
	String nome;
	
	String titoloCompleto;
	
	int anno;
	
	String isbn;
	
	Double punteggioMin;
	
	Double punteggioMax;
	
    String testoRecensione;
	
}
