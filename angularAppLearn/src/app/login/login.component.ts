import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardAuthService } from '../service/hard-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = 'spreddy';
  password = '';
  erroeMessage = 'Invalid User';
  invaldLogin =  false;
  constructor(private router : Router , private auth : HardAuthService) {
   }

  ngOnInit(): void {
  }

  loginSubmit(): void{
    if (this.auth.authontication(this.username,this.password)) {
      this.router.navigate(['welcome' , this.username]);
    }else{
      this.invaldLogin = true;
    }

  }


  loginSubmitBasicAuth(): void{
   this.auth.authonticationService(this.username,this.password)
   .subscribe(
     data => {
       this.router.navigate(['welcome' , this.username])
     },
    error =>{
        sessionStorage.removeItem('authUser');
       this.invaldLogin = true;
    }
   )

  }

  loginSubmitJwtlAuth(): void{
    console.log(1234)
    this.auth.executeJWTAuthService(this.username,this.password)
    .subscribe(
      data => {
        this.router.navigate(['welcome' , this.username])
      },
     error =>{
      console.log(error);
         sessionStorage.removeItem('authUser');
        this.invaldLogin = true;
     }
    )
 
   }
 
}
