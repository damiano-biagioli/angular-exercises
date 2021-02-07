import { BookSample } from './../model/bookSample';
import { BookSampleDialogComponent } from './../book-sample-dialog/book-sample-dialog.component';
import { LibroService } from './../libro.service';
import { CarrelloService } from './../carrello.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { AuthService } from '../auth.service';
import { SelectionModel } from '@angular/cdk/collections';
import { Libro } from '../model/libro';
import { Recensione } from '../model/recensione';
//import { resolve } from 'dns';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';
import { BookDetailComponent } from '../book-detail/book-detail.component';
/*
export interface Libro {
  idLibro: number;
  nome: string;
  titoloCompleto: string;
  anno: number;
  isbn: string;
  punteggio: number;
  cover: string;
  author: string;
  listaRecensioni: any[];
}*/
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class BookListComponent implements OnInit {
  // @Output() toggle: EventEmitter<string> = new EventEmitter();

  displayedColumns: string[] = ['select','nome', 'titoloCompleto', 'anno','author','isbn', 'punteggio','prezzo'];
  dataSource: Libro[];

   initialSelection = [];
   allowMultiSelect = true;
   private inCarrello: Libro[]=[];
selection = new SelectionModel<Libro>(this.allowMultiSelect, this.initialSelection);
/** Whether the number of selected elements matches the total number of rows. */
private isAllSelected() {
  const numSelected = this.selection.selected.length;
  const numRows = this.dataSource.length;
  return numSelected == numRows;
}

/** Selects all rows if they are not all selected; otherwise clear selection. */
private masterToggle() {
  this.isAllSelected() ?
    this.selection.clear() :
    this.dataSource.forEach(row => this.selection.select(row));
}

constructor(private http: HttpClient, private auth: AuthService,
  private carrService:CarrelloService,public dialog: MatDialog,public  libroservice: LibroService) { }
message = 'none';
ngOnInit() {

  this.http.get('http://127.0.0.1:8080/protected/hello', { responseType: 'text' }).subscribe(
    (res) => {
      console.log("received response");
      console.log(res);
      const idToken = localStorage.getItem("jwt_token");
     
      let tkn = JSON.parse(atob(idToken.split('.')[1]));
      this.message = tkn.sub;
      this.auth.updateMessage(tkn.sub);
      // this.toggle.emit(this.message);
      // expected output: 123

    }, (err) => {
      
      console.log(err);
      if (err === 'Unauthorized') {
        this.message = err;
        console.log("error!!");
        this.auth.updateMessage('none');
      }
    }
  );

  this.http.get<Libro[]>('http://127.0.0.1:8080/public/listaLibri').subscribe(data => {
    
    this.dataSource = data;
    console.log(this.dataSource);



  });
  this.carrService.removed.subscribe(data => { this.inCarrello= this.inCarrello.filter(item => { item!=data}) ; });
  this.carrService.selected.subscribe(data => this.inCarrello.push(data));
}
todo() {
  window.alert("todo at "+new Date());
}
viewDetails(b:Libro) {
  this.http.get<Recensione[]>('http://127.0.0.1:8080/public/libro/'+b.idLibro).subscribe(data => {
    let emptySample : Recensione = {  
       idRecensione :-1,
      testo:'empty review',
      libro:b,
      user:{username:"no_user",password:"pass"}};
    
    console.log(data);
    const dialogRef = this.dialog.open(BookDetailComponent, {
      width: '700px',
      data: data[0]!=undefined? data :[emptySample]
    });

    dialogRef.afterClosed().subscribe(result => { 
      console.log('The dialog was closed');
      //this.animal = result;
    });


  });
}
addToCart(b:Libro){
this.carrService.aggiugiAlCarrello(b);
console.log(this.inCarrello);
}
displayCartButton(b:Libro) {
  console.log("aaaa22");
 return this.inCarrello.indexOf(b)<0 && this.message!='none';
}


viewSample(b:Libro): void {

  this.libroservice.getSamplesByBook(b.idLibro).subscribe(resp => {
    console.log(resp);
    let emptySample : BookSample = {id: 'abc',
    idBook:-1,
    sample: 'dati non presenti'};
      const dialogRef = this.dialog.open(BookSampleDialogComponent, {
        width: '550px',
        data: resp[0]!=undefined? resp[0] :emptySample
      });

      dialogRef.afterClosed().subscribe(result => { 
        console.log('The dialog was closed');
        //this.animal = result;
      });
  })
}
}
