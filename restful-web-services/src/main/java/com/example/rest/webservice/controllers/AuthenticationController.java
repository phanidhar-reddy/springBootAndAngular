package com.example.rest.webservice.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.webservice.constants.ControllerURIConstants;
import com.example.rest.webservice.model.AuthorizationBean;

@CrossOrigin
@RestController
public class AuthenticationController {

	@GetMapping(path = ControllerURIConstants.URI_BASE_AUTH)
	public AuthorizationBean checkForUser() {
		return new AuthorizationBean("User Logged in");
	}
	
}
