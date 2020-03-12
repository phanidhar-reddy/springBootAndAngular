package com.example.rest.webservice.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rest.webservice.model.Todo;

@Service
public class HardCodedService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo( "spreddy", "Angular", false, new Date()));
		todos.add(new Todo( "spreddy", "Spring", false, new Date()));
		todos.add(new Todo( "spreddy", "Badminton", false, new Date()));
		todos.add(new Todo( "spreddy", "PLSQL", false, new Date()));
		todos.add(new Todo("raja", "PLSQL", false, new Date()));
	}
	
	 public List<Todo> getToDoData(String name, Long id){
		 return fetchById(id);
	 }

	public List<Todo> deleteToDo(Long id) {
		List<Todo> todo = fetchById(id);
		todos.removeAll(todo);
		return todo;
	}
	
	List<Todo> fetchById(Long id){
		return todos.stream()
				 .filter(person -> 
			 		(person.getId() == (id)))
			 .collect(Collectors.toList());
	}

	public List<Todo> getAllTodos(String username) {
		return  todos.stream()
				 .filter(person -> 
			 		person.getName().equalsIgnoreCase(username))
			 .collect(Collectors.toList());
		
	}

	public Todo save(Todo todo, String username) {
		todo.setName(username);
		todos.add(todo);
		return todo;
	}
	
	public Todo updateTodo(Todo todo) {
		deleteToDo(todo.getId());
		todos.add(todo);
		return todo;
	}
}
