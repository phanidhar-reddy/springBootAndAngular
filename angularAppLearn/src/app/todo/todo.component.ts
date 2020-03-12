import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todos } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todo : Todos ;
  userName  = "";
  id : number;
  constructor(private service : TodoDataService ,
    private activatedRouet : ActivatedRoute,
    private router : Router
    ) { }

  ngOnInit(): void {

    this.userName = sessionStorage.getItem('authUser');
    this.id = this.activatedRouet.snapshot.params['id'];
    this.todo = new Todos(0,"","",false,new Date());
    if (this.id != 0) {
    this.service.getTodoData(this.userName,this.id)
    .subscribe(
      response => {
        this.todo = response 
      }
    );
    }
  }
  saveData(){
    if (this.id != 0) {
      this.service.updateToDoData(this.userName,this.todo).subscribe(
        data => { this.router.navigate(['todos']) });
    } else {
      this.service.addTodo(this.userName,this.todo).subscribe(
        data => { this.router.navigate(['todos']) });
    }
    
    
  }
}
