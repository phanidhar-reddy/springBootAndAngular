import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todos } from 'src/app/list-todos/list-todos.component';
import { HardAuthService } from '../hard-auth.service';
import { APT_URL, APT_URL_JPA } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {
  
  constructor(
    private httpClient : HttpClient
    ) {
   }

  retriveDataForUser(username : String){
    return this.httpClient.get<Todos[]>(`${APT_URL_JPA}/user/${username}/todos`);
  }

  deleteTodo(username, id){
    return this.httpClient.delete(`${APT_URL_JPA}/user/${username}/todos/${id}`);
  }

  getTodoData(username, id){
    return this.httpClient.get<Todos>(`${APT_URL_JPA}/user/${username}/todos/${id}`);
  }

  updateToDoData(username,todo: Todos) {
    return this.httpClient.put(`${APT_URL_JPA}/user/${username}/todos`,todo);
  }

  addTodo(username,todo: Todos) {
    return this.httpClient.post(`${APT_URL_JPA}/user/${username}/todos`,todo);
  }

}
