package com.rest.scloud.springCloud.controllers;

import java.net.URI;


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

import com.fasterxml.jackson.databind.JsonNode;
import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.service.UsersServices;

@RestController
@CrossOrigin
public class UserCloudController {

	@Autowired // autowiring
	private UsersServices userServices;

	@GetMapping(path = ControllerURIConstants.URI_USERS_JPA)
	public JsonNode getAllUsers(@PathVariable String username) {
		return userServices.findAllUsers(username);
	}

	@DeleteMapping(path = ControllerURIConstants.URI_USERS_JPA + ControllerURIConstants.URI_ID)
	public ResponseEntity<Void> deleteUser(@PathVariable String username, @PathVariable Long id) {

		userServices.delete(username,id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = ControllerURIConstants.URI_USERS_JPA + ControllerURIConstants.URI_ID)
	public EntityModel<JsonNode> getUser(@PathVariable String username, @PathVariable Long id) {
		JsonNode users = userServices.findById(username, id);
		//HATEOAS FOR ALL USERS
		 EntityModel<JsonNode> entityModel = new EntityModel(users); 
		 WebMvcLinkBuilder  linkBuilder = WebMvcLinkBuilder.linkTo(
		 WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers(username));
		 entityModel.add(linkBuilder.withRel("all-users"));
		
		return entityModel;
	}

	@PutMapping(path = ControllerURIConstants.URI_USERS_JPA)
	public ResponseEntity<Void> updateUser(@PathVariable String username, @RequestBody // Data pun in body can be
																						// accessed this way
	JsonNode users) {
		users = userServices.save(users, username);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(users.get("id").asText()).toUri();

		return users.get("id").asText() != "0" ? ResponseEntity.created(uri).build()
				: ResponseEntity.badRequest().build();

	}

	@PostMapping(path = ControllerURIConstants.URI_USERS_JPA)
	public ResponseEntity<Void> addUser(@PathVariable String username, @RequestBody JsonNode users) {
		users = userServices.update(users, username);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(users.get("id").asText()).toUri();

		return users.get("id").asText() != "0" ? ResponseEntity.created(uri).build()
				: ResponseEntity.badRequest().build();

	}

}
