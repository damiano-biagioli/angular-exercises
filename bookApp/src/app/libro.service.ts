import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookSample } from './model/bookSample';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  constructor(private httpClient:HttpClient) { }

  public  getSamples():Observable<BookSample[]> {
    return this.httpClient.get<BookSample[]>('http://127.0.0.1:8080/public/listaEstratti');
  }

  
  
  public getSamplesByBook(idBook:number): Observable<BookSample[]> {
    return this.httpClient.get<BookSample[]>('http://127.0.0.1:8080/private/estratto/'+idBook)
  }
}
