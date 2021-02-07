import { DemoMaterialModule } from './material-module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BookListComponent } from "./home/home.component";
import { AuthInterceptor } from './auth-interceptor';
import { StandardComponent } from './standard/standard.component';
import { NavigationComponent } from './navigation/navigation.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarrelloComponent } from './carrello/carrello.component';
import { BookSampleDialogComponent } from './book-sample-dialog/book-sample-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BookDetailComponent } from './book-detail/book-detail.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BookListComponent,
    StandardComponent,
    NavigationComponent,
    CarrelloComponent,
    BookSampleDialogComponent,
    BookDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,ReactiveFormsModule, BrowserAnimationsModule
    ,DemoMaterialModule, NgbModule,MatDialogModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
}],
entryComponents: [
  BookSampleDialogComponent
],
  bootstrap: [AppComponent]
})
export class AppModule { }
