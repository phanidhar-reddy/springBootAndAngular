package com.rest.scloud.springCloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.service.AuthorzationServices;

@RestController
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthorzationServices authorzationServices;
	
	@PostMapping(path = ControllerURIConstants.AUTH_URI+"/{username}")
	public ResponseEntity<Void> getAuthTokenAndStore(@PathVariable String username){
		authorzationServices.getAuthService(username);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
