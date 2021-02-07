import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Recensione } from '../model/recensione';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
dataSource:Recensione[];
displayedColumns: string[] = ['testo',"username"];
  
  constructor(@Inject(MAT_DIALOG_DATA) public data: Recensione[]) {this.dataSource=data; }

  ngOnInit(): void {
  }

}
