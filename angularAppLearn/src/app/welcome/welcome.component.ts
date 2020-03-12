import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HardAuthService } from '../service/hard-auth.service';
@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  message: string = 'welcome Component';
  name: string = '';
  constructor(private route : ActivatedRoute , 
    public http :HttpClient ,
    private authService : HardAuthService
    ) { }

  ngOnInit(): void {
    this.name =  this.route.snapshot.params['name'];
  }

  getMessage(){
    this.http.get('http://localhost:9214/hellowWorldBean'
    ,{headers : this.authService.createAuthHeader()}).subscribe(
      responce => this.handleResponse(responce) ,
      error => this.handleErrorResponse(error)
      );
  }
  handleResponse(response){
    console.log(response);
  }
  handleErrorResponse(error){
    console.log(error.message);
  }
}
