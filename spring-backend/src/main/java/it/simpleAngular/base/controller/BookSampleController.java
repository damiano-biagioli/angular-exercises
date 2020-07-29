package it.simpleAngular.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.simpleAngular.base.dao.mongo.BookSampleRepository;
import it.simpleAngular.base.model.mongo.BookSample;

@RestController
public class BookSampleController {
	@Autowired
	   BookSampleRepository sampleRepository;
	
	 @RequestMapping(value = "public/listaEstratti", method = RequestMethod.GET)
	    public @ResponseBody List<BookSample> getListaEstratti(){
	        return sampleRepository.findAll();
	    }
	 
	 @RequestMapping(value = "private/estratto/{id}", method = RequestMethod.GET)
	    public @ResponseBody List<BookSample> getEstrattiLibro( @PathVariable("id") int idLibro){
	        return sampleRepository.findByIdBook(idLibro);
	    }
}
