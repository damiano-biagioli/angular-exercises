package it.simpleAngular.base;

import it.simpleAngular.base.dao.AuthorityRepository;
import it.simpleAngular.base.dao.LibroRepository;
import it.simpleAngular.base.dao.MetodoPagamentoRepository;
import it.simpleAngular.base.dao.UserRepository;
import it.simpleAngular.base.model.Authority;
import it.simpleAngular.base.model.AuthorityName;
import it.simpleAngular.base.model.Libro;
import it.simpleAngular.base.model.MetodoPagamento;
import it.simpleAngular.base.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Arrays;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class Application {
	

	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UserRepository userRepository,
			LibroRepository libroRepository,MetodoPagamentoRepository metodoRepository, AuthorityRepository authorityRepository) {
		return (args) -> {

			User user=userRepository.findByUsername("admin");

			if(user == null){

				/**
				 * Inizializzo i dati del  test
				 */


				Authority authorityAdmin=new Authority();
				authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
				authorityAdmin=authorityRepository.save(authorityAdmin);

				Authority authorityUser=new Authority();
				authorityUser.setName(AuthorityName.ROLE_USER);
				authorityUser=authorityRepository.save(authorityUser);


				List<Authority> authorities = Arrays.asList(new Authority[] {authorityAdmin,authorityUser});


				user = new User();
				user.setAuthorities(authorities);
				user.setEnabled(true);
				user.setUsername("admin");
				user.setPassword(passwordEncoder.encode("admin"));

				userRepository.save(user);
				
				Libro libro = new Libro();
				libro.setAnno(2019);
				libro.setIsbn("rgrs432rrg543");
				libro.setNome("come imparare  a programmare in c");
				libro.setPunteggio(6.0);
				libro.setTitoloCompleto("Donald Knuth - come imparare  a programmare in c con poco sforzo ");
				
				libroRepository.save(libro);
				Libro libro2 = new Libro();
				libro2.setAnno(2018);
				libro2.setIsbn("435yt7777tt7");
				libro2.setNome("come imparare  a programmare in java");
				libro2.setPunteggio(7.0);
				libro2.setTitoloCompleto("OOP - tecniche e programmazione di  base ");
				libroRepository.save(libro2);
				
				MetodoPagamento  carta = new MetodoPagamento();
				carta.setNomeMetodo("carta di credito");
				MetodoPagamento  contrassegno = new MetodoPagamento();
				contrassegno.setNomeMetodo("contrassegno");
				
				metodoRepository.save(carta);
				metodoRepository.save(contrassegno);
				
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
