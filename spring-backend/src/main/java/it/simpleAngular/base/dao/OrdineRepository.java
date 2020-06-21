package it.simpleAngular.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.simpleAngular.base.model.Ordine;


public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
   

}