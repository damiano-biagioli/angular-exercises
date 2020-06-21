import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {  Router } from '@angular/router';
import { AuthService } from '../auth.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form:FormGroup;

  constructor(private fb:FormBuilder,
               private authService: AuthService,
               private router: Router, private _snackBar: MatSnackBar) {

      this.form = this.fb.group({
          email: ['email',[Validators.required,Validators.email]],
          password: ['password',[Validators.required,Validators.email]]
      });
  }

  getErrorMessage() {
    return this.form.get('email').hasError('required') ? 'Inserire una email' :
        this.form.get('email').hasError('email') ? ' email non valida' :
            '';
  }

  login() {
      const val = this.form.value;

      if (val.email && val.password) {
          this.authService.login(val.email, val.password)
              .subscribe(
                  (res:any) => {
                      console.log("User is logged in");
                      console.log(res);
                      this._snackBar.open('utente riconosciuto','chiudi', {
                        duration: 3000
                      });
                      this.router.navigateByUrl('/home');
                      // prendere l'header e salvarlo nel local storage... aggiungere un http interceptor
                  }, 
                  (err:any) => { 
                      console.log(err);
                      this._snackBar.open('errore login','close', {
                    duration: 3000
                  });}
              );
      }
  }
}
