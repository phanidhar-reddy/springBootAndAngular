import { Component, OnInit } from '@angular/core';
import { HardAuthService } from '../service/hard-auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  userId : string = "";
  constructor(private authService : HardAuthService) { }

  ngOnInit(): void {
    this.userId = sessionStorage.getItem('authUser');
    this.authService.logout();
  }

}
