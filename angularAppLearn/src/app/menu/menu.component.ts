import { Component, OnInit } from '@angular/core';
import { HardAuthService } from '../service/hard-auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  userId: string  = "";
  isUserLoggedIn = false;
  constructor(public authService : HardAuthService) { 
  }

  ngOnInit(): void {
   this.isUserLoggedIn = this.authService.isUserLoggedIn();
  }

}
