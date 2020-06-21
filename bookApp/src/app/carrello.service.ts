import { Injectable } from '@angular/core';
import { Libro } from './model/libro';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CarrelloService {
  private selezionati: Libro[] = [];
  public selected = new Subject<any>();
  public removed = new Subject<any>();
  constructor() { }

public  getSelezionati():Libro[] {
  return this.selezionati;
}
public clear() {
  this.selezionati = [];
}
public aggiugiAlCarrello(b: Libro) {
  if(this.selezionati.indexOf(b)<0) {

  this.selezionati.push(b); } else  { alert("Elemento già presente");}
  this.selected.next(b);
}
public rimuoviDaCarrello(b: Libro) {
  this.selezionati = this.selezionati.filter(item => (item !== b));
  this.removed.next(b);
}
public isPresent(b: Libro) {
  console.log("calling!");
  return this.selezionati.indexOf(b)>=0;



}
}
