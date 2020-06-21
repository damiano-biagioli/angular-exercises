package it.simpleAngular.base.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.simpleAngular.base.model.Recensione;


public interface RecensioneRepository extends JpaRepository<Recensione, Integer> {
	@Query("select r from Recensione r where r.libro.idLibro = ?1")
     List<Recensione> trovaPerLibro(Integer idLibro);
}