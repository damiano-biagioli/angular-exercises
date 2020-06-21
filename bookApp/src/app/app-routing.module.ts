import { CarrelloComponent } from './carrello/carrello.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BookListComponent } from "./home/home.component";
import { StandardComponent } from './standard/standard.component';
//import { CarrelloComponent } from'./carrello/carrello.component';
const routes: Routes = [{
  path: '',
  component: StandardComponent
},{
  path: 'login',
  component: LoginComponent
},{
  path: 'carrello',
  component: CarrelloComponent
}
,{
  path: 'home',
  component: BookListComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


