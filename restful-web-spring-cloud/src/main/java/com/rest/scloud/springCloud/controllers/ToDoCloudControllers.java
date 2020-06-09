package com.rest.scloud.springCloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.model.Todo;
import com.rest.scloud.springCloud.service.TodoDataServices;

@CrossOrigin
@RestController
public class ToDoCloudControllers {
		
	@Autowired
	private TodoDataServices services;
	
	@GetMapping(path = ControllerURIConstants.URI_TODO)
	public List<?> getTodoData(@PathVariable String username){
		return services.getAllTodosData(username);
	}
	
}
