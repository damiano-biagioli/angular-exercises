package it.simpleAngular.base.model.mongo;

import org.springframework.data.annotation.Id;


public class BookSample {

  @Id
   String id;
   Integer idBook;
   String sample;
   String recap;
   Integer chapter;

  public BookSample() {}

public BookSample(String recap, String sample) {
	this.sample=sample;
	this.recap=recap;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getSample() {
	return sample;
}

public void setSample(String sample) {
	this.sample = sample;
}

public String getRecap() {
	return recap;
}

public void setRecap(String recap) {
	this.recap = recap;
}

public Integer getChapter() {
	return chapter;
}

public void setChapter(Integer chapter) {
	this.chapter = chapter;
}

public Integer getIdBook() {
	return idBook;
}

public void setIdBook(Integer idBook) {
	this.idBook = idBook;
}

 
  

  

}
