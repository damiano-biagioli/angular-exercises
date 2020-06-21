import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { shareReplay, tap } from 'rxjs/operators';
import { HttpClient, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public message ='changeme'
  constructor(private http: HttpClient) {
  }
   messageSrc: Subject<string>= new Subject<string>();
  login(username: any, password: any) /*:Observable<string>*/ {
   // throw new Error("Method not implemented.");
   console.log("login attempt")
   return this.http.post('http://127.0.0.1:8080/public/login', {username: username, password:password}, {observe: 'response'}).pipe(
   // this is just the HTTP call,
   // we still need to handle the reception of the token
     tap((res:HttpResponse<any>) =>  {this.setSession(res)}),
  /* shareReplay(1)*/);
  }


  public updateMessage(msg:string) {
     this.messageSrc.next(msg);
  }
  private setSession(authResult:HttpResponse<any>) {
    //const expiresAt = moment().add(authResult.expiresIn,'second');
console.log("jwt is "+ authResult.headers.get('X-Auth'));
    localStorage.setItem('jwt_token', authResult.headers.get('X-Auth'));
    //localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    }

    logout() {
      localStorage.removeItem("jwt_token");
      // localStorage.removeItem("expires_at");
    }
}
