import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, UrlTree, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { HardAuthService } from './hard-auth.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGaurdService implements CanActivate{
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  : boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    //console.log("Chooche");
    return this.cehckForLoginToLoginP();
  }

  constructor(private authService : HardAuthService,private router : Router) { }

  cehckForLoginToLoginP(){
    if (!this.authService.isUserLoggedIn()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;;
  }
}
