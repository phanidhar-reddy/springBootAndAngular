package com.example.rest.webservice.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.example.rest.webservice.exceptions.UserNotFoundException;
import com.example.rest.webservice.model.Todo;
import com.example.rest.webservice.model.Users;
import com.example.rest.webservice.services.TodoServices;
import com.example.rest.webservice.services.UsersServices;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired //autowiring  
	private UsersServices userServices; 
	
	@GetMapping(path = ControllerURIConstants.URI_USERS_JPA) 
	public List<Users> getAllUsers(@PathVariable String username){
		return userServices.findAllUsers();
	}
	
	@DeleteMapping(path = ControllerURIConstants.URI_USERS_JPA + ControllerURIConstants.URI_ID)
	public ResponseEntity<Void> deleteUser(@PathVariable String username , @PathVariable Long id ){
		
		  userServices.delete(id);
				  return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = ControllerURIConstants.URI_USERS_JPA + ControllerURIConstants.URI_ID)
	public EntityModel<Users> getUser(@PathVariable String username , @PathVariable Long id ){
		Optional<Users> users = userServices.findById(username,id); 
		if (!users.isPresent()) {
			throw new UserNotFoundException("Id : "+id);
		}
			
		//HATEOAS  creating link for all users
		
		EntityModel<Users> entityModel = new EntityModel(users.get());
		WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers(username));
		entityModel.add(linkBuilder.withRel("all-users"));
		return  entityModel;
	}
	
	@PutMapping(path = ControllerURIConstants.URI_USERS_JPA)
	public ResponseEntity<Void> updateUser(@PathVariable String username ,@Valid @RequestBody //Data pun in body can be accessed this way
			Users users ){
		users = userServices.save(users,username);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(users.getId())
		.toUri();
			
		return users.getId()!=0 ? ResponseEntity.created(uri).build() :  ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping(path = ControllerURIConstants.URI_USERS_JPA)
	public ResponseEntity<Void> addUser(@PathVariable String username ,@Valid @RequestBody Users users ){
		users = userServices.save(users,username);
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(users.getId())
		.toUri();
		return users.getId()!=0 ? ResponseEntity.created(uri).build() :  ResponseEntity.badRequest().build();
		}
	
	
}
