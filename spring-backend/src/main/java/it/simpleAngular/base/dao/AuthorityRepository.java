package it.simpleAngular.base.dao;


import it.simpleAngular.base.model.Authority;
import it.simpleAngular.base.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}