import { Component, OnInit } from '@angular/core';
import { Libro } from '../model/libro';
import { CarrelloService } from '../carrello.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.css']
})
export class CarrelloComponent implements OnInit {
   selected :Libro[] = [];
   totale:number=0;
  constructor(private carrService:CarrelloService,private http: HttpClient) { }

  ngOnInit() {
     this.selected=this.carrService.getSelezionati();
     for (let book of this.selected) {
      this.totale += book.prezzo;}
  }
public ordina() {
for (let book of this.selected) {
 // this.totale += book.prezzo;
  this.http.post<Libro>('http://127.0.0.1:8080/protected/createOrdine',book).subscribe(data=> console.log(data));
}


}
}
