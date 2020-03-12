package com.example.rest.webservice.controllers;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservice.constants.ControllerURIConstants;
import com.example.rest.webservice.model.Todo;
import com.example.rest.webservice.repositries.ToDoRepository;
import com.example.rest.webservice.services.HardCodedService;
import com.example.rest.webservice.services.TodoServices;

@CrossOrigin //Allows cross origin access
@RestController  //Tells that this is rest controller
public class ToDoController {
	
	@Autowired //autowiring  
	private TodoServices toDoServices; 
	
	@GetMapping(path = ControllerURIConstants.URI_TODO_JPA) 
	public List<Todo> getAllTodos(@PathVariable String username){
		return toDoServices.getTodosByUserName(username);
	}
	
	@DeleteMapping(path = ControllerURIConstants.URI_TODO_JPA + ControllerURIConstants.URI_ID)
	public ResponseEntity<Void> deleteTodo(@PathVariable String username , @PathVariable Long id ){
		
		  toDoServices.deleteToDo(id);
				  return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = ControllerURIConstants.URI_TODO_JPA + ControllerURIConstants.URI_ID)
	public Todo getTodo(@PathVariable String username , @PathVariable Long id ){
		return toDoServices.getToDoData(username,id)==null ? null : toDoServices.getToDoData(username,id).get();
	}
	
	@PutMapping(path = ControllerURIConstants.URI_TODO_JPA)
	public ResponseEntity<Void> updateToDo(@PathVariable String username , @RequestBody //Data pun in body can be accessed this way
			Todo todo ){
		todo = toDoServices.save(todo,username);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(todo.getId())
		.toUri();
			
		return todo.getId()!=0 ? ResponseEntity.created(uri).build() :  ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping(path = ControllerURIConstants.URI_TODO_JPA)
	public ResponseEntity<Void> addToDo(@PathVariable String username , @RequestBody Todo todo ){
		todo = toDoServices.save(todo,username);
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(todo.getId())
		.toUri();
		return todo.getId()!=0 ? ResponseEntity.created(uri).build() :  ResponseEntity.badRequest().build();
		}
	
	
}
