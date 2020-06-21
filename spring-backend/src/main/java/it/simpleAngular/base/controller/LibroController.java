package it.simpleAngular.base.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.simpleAngular.base.dao.LibroRepository;
import it.simpleAngular.base.dao.RecensioneRepository;
import it.simpleAngular.base.model.Libro;
import it.simpleAngular.base.model.Recensione;

@RestController
public class LibroController {
	
	
	@Autowired
	LibroRepository libroRepository;
   @Autowired
   RecensioneRepository recensioneRepository;
	
    @RequestMapping(value = "public/listaLibri", method = RequestMethod.GET)
    public @ResponseBody List<Libro> getListaLibri(){
        return libroRepository.findAll();
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
    @RequestMapping(value = "public/libro/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Recensione> getRecensioniLibro(@PathVariable("id") Integer idLibro){
        return recensioneRepository.trovaPerLibro(idLibro);
    }
}
