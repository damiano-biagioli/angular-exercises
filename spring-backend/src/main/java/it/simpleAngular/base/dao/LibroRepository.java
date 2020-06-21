package it.simpleAngular.base.dao;

import it.simpleAngular.base.model.Libro;
import it.simpleAngular.base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Libro findByTitoloCompleto(String titoloCompleto);

}