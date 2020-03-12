import { Injectable } from '@angular/core';
import { HttpInterceptor ,HttpRequest , HttpHandler ,HttpEvent} from '@angular/common/http';
import { HardAuthService } from '../hard-auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor { 

  //Overridden method
  intercept(req: HttpRequest<any>, next:HttpHandler){ //acts as a filter
    if (this.authService.getAuthToken() && this.authService.getAuthUser()) {
    req = req.clone( {  setHeaders 
      :{
        Authorization : this.authService.getAuthToken()
      } 
      }
    )
  }
        return next.handle(req); //continue
  }

  constructor(private authService : HardAuthService) { 
  }
}
