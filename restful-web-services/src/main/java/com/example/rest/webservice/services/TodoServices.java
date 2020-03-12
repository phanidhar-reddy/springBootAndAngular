package com.example.rest.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.webservice.model.Todo;
import com.example.rest.webservice.repositries.ToDoRepository;

@Service
public class TodoServices {

	@Autowired
	private ToDoRepository todoRepo;

	public List<Todo> getAllTodos(String username) {
		return todoRepo.findAll();
	}

	public void deleteToDo(Long id) {
		todoRepo.deleteById(id);
	}

	public Todo save(Todo todo, String name) {
		todo.setName(name);
		return todoRepo.save(todo);
	}
	
	 public Optional<Todo> getToDoData(String name, Long id){
		 return todoRepo.findById(id);
	 }

	public List<Todo> getTodosByUserName(String username) {
		return todoRepo.findByName(username);
	}
}
