import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos : Todos[];
  message: string;

  constructor(private todoSevice : TodoDataService , private router : Router) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  deleteTodo(id){
    this.todoSevice.deleteTodo(sessionStorage.getItem('authUser') , id).subscribe(
      response => {this.message = `Delete Sucessful for ${id}`
      this.refreshTodos()}
    );
  }

  refreshTodos(){
    this.todoSevice.
    retriveDataForUser(sessionStorage.getItem('authUser')).subscribe(
      respone =>{
       this.todos = respone;
      }
     );
  }

  updateTodo(id){
    this.router.navigate(['todos',id]);
  }

}

export class Todos{
  constructor( 
      public id: number , 
      public name: string , 
      public todos: string , 
      public done: boolean , 
      public targetDate: Date , 
     ){ }

}
