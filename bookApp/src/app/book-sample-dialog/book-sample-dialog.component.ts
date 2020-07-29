import { BookSample } from './../model/bookSample';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-book-sample-dialog',
  templateUrl: './book-sample-dialog.component.html',
  styleUrls: ['./book-sample-dialog.component.css']
})
export class BookSampleDialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: BookSample) { }

  ngOnInit(): void {
    console.log('dialog init')
  }

}
