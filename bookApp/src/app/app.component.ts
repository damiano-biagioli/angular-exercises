import { CarrelloService } from './carrello.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  title = 'mini libreria';
  message='none';

  ngOnInit(): void {
   this.auth.messageSrc.subscribe(
     (val:string) => {    this.message=val;}
   );


   const idToken = localStorage.getItem("jwt_token");
   if(idToken) {
      let tkn = JSON.parse(atob(idToken.split('.')[1]));
      console.log("token is" ); console.log(tkn);
      this.http.get('http://127.0.0.1:8080/protected/hello', { responseType: 'text' }).subscribe(
        (res) => {
          console.log("received response");
          console.log(res);
          this.message = res;
          this.auth.updateMessage(res);
          // this.toggle.emit(this.message);
          // expected output: 123
          this.auth.messageSrc.next(tkn.sub);
        }, (err) => {
          
          console.log(err);
          if (err === 'Unauthorized') {
            this.message = err;
            console.log("error!!");
            this.auth.messageSrc.next('none');
          }
        });
   }
  }
  constructor(private auth:AuthService, private route: ActivatedRoute,
    private router: Router,private http:HttpClient , private carrService:CarrelloService) {}

   public goToLogin(){
     this.router.navigate(['/login']);
  }

  public logout(){
    localStorage.clear();
    this.auth.messageSrc.next('none');
    this.router.navigate(['']);
    this.carrService.clear();
 }
 public home(){
  
  this.router.navigate(['home']);
}


public goToCarrello(){
  
  this.router.navigate(['carrello']);
}

}
