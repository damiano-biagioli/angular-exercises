package it.simpleAngular.base.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.simpleAngular.base.dao.LibroRepository;
import it.simpleAngular.base.dao.OrdineRepository;
import it.simpleAngular.base.dao.UserRepository;
import it.simpleAngular.base.model.Libro;
import it.simpleAngular.base.model.MetodoPagamento;
import it.simpleAngular.base.model.Ordine;
import it.simpleAngular.base.model.User;

@RestController
public class OrdineController {
	
	
	@Autowired
	LibroRepository libroRepository;
   
	@Autowired
	OrdineRepository ordineRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "protected/createOrdine", method = RequestMethod.POST)
    public @ResponseBody Ordine createOrdine(@RequestBody Libro book){
        Ordine ord= new Ordine();
      
        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User us= userRepository.findByUsername(userDetails.getUsername());
        ord.setEseguito(0);
        
         ord.setImporto(book.getPrezzo());
         ord.setLibro(book);
         MetodoPagamento metodoPagamento = new MetodoPagamento();
         metodoPagamento.setIdMetodoPagamento(6);
		ord.setMetodoPagamento(metodoPagamento);
		ord.setUser(us);
	
		ordineRepository.save(ord);
		return ord;
    }
    @PersistenceContext
	EntityManager entitymanager;
    // cercare StoricoReferenteRest e poi fare il metodo con i filtri cosi
    /*
         endpoint  cui e'possibile accedere  solo con token valido
   
    @RequestMapping(value = "protected/hello", method = RequestMethod.GET)
    public @ResponseBody String protectedHelloWorld(){
        return "Ciao Mondo-Protetto";
    }  */
}
