package it.simpleAngular.base.dao;

import it.simpleAngular.base.model.Libro;
import it.simpleAngular.base.model.MetodoPagamento;
import it.simpleAngular.base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamento, Integer> {
	MetodoPagamento findByNomeMetodo(String nomeMetodo);

}