package com.example.rest.webservice.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservice.model.Todo;

public interface ToDoRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByName(String name);
}
