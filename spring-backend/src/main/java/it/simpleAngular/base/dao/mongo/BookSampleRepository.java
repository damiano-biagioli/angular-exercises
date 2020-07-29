package it.simpleAngular.base.dao.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.simpleAngular.base.model.mongo.BookSample;

public interface BookSampleRepository extends MongoRepository<BookSample, String> {

	  public Optional<BookSample> findById(String id);
	  public List<BookSample> findByRecap(String recap);
	  public List<BookSample> findByIdBook(int idBook);

}