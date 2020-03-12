import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { APT_URL } from '../app.constants';


export const TOKEN = 'token';
export const AUTH_USER = 'authUser';
@Injectable({
  providedIn: 'root'
})
export class HardAuthService {

  constructor(private http : HttpClient) { }

  authontication(username , password) : boolean{
    if (username === 'spreddy' && password === '1234') {
      sessionStorage.setItem(AUTH_USER,username);
      sessionStorage.setItem('password',password);
      return true;
    }
    return false
  }

  /**
   * Spring Security implimentation
   * @param username 
   * @param password 
   */
  authonticationService(username , password){
    sessionStorage.setItem(AUTH_USER,username);
    sessionStorage.setItem(TOKEN,this.getBasicAuthStringHeader(username,password));
   return this.http.get<AuthorizationBean>
   (`${APT_URL}/basicauth`).pipe(
     map(
       data=>{
              return data;
       }
     )
   );
  }

/**
 * JWT AUTHORIZATIONS SERVICES
 * @param username 
 * @param password 
 */
  executeJWTAuthService(username , password){
    console.log(1234)
     return this.http.post<any>(`${APT_URL}/authenticate`,{
       username : username,
       password : password
     }
       ).pipe(
     map(
       data=>{
        sessionStorage.setItem(AUTH_USER,username);
        sessionStorage.setItem(TOKEN,`Bearer ${data.token}`);
              return data;
       }
     )
   );
  }


  /**
 * To get UserId
 */
getAuthUser(){
  return sessionStorage.getItem(AUTH_USER);
}

/**
 * To get Token
 */
getAuthToken(){
  if (this.getAuthUser()) {
    return sessionStorage.getItem(TOKEN);
  }
  return null;
}

/**
 * CHeck if user is logged in 
 */
  isUserLoggedIn() : boolean{
    let user = this.getAuthUser();
    return !(user === null)
  }

  /**
   * LOGOT FROM SESSION
   */
  logout(){
    sessionStorage.removeItem(AUTH_USER);
    sessionStorage.removeItem(TOKEN);
  }

  createAuthHeader(){
    let authUser = this.getAuthUser()
    let password = sessionStorage.getItem('password');
   return this.createAuthHeaderUserPass(authUser,password);
  }

  getBasicAuthStringHeader(authUser,password){
      return 'Basic ' + window.btoa(authUser + ':' + password);
  }

  createAuthHeaderUserPass(authUser,password){
    console.log(authUser + ':' + password);
    let authData = this.getBasicAuthStringHeader(authUser,password);
    console.log(authData);
    return new HttpHeaders({
      Authorization : authData
    })
  }


}

export class AuthorizationBean{
  constructor(
    public message :string
  ){  }
}


