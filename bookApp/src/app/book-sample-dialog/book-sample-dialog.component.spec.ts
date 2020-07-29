import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookSampleDialogComponent } from './book-sample-dialog.component';

describe('BookSampleDialogComponent', () => {
  let component: BookSampleDialogComponent;
  let fixture: ComponentFixture<BookSampleDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookSampleDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookSampleDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
