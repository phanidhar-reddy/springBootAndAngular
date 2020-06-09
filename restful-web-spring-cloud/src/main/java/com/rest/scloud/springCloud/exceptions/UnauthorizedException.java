package com.rest.scloud.springCloud.exceptions;

import java.util.Date;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.JsonNode;
import com.rest.scloud.springCloud.controllers.AuthController;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
	private Date timestamp;
	private String message ;
	private String details ;
	private String uri;
	public Date getTimestamp() {
		return timestamp;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public UnauthorizedException(Date timestamp, String details,String username) {
		super();
		this.timestamp = timestamp;
		this.message = "Hit the Uri to authorize ";
		this.details = details;
		 WebMvcLinkBuilder
		 linkBuilder = WebMvcLinkBuilder.linkTo(
		 WebMvcLinkBuilder.methodOn(AuthController.class).getAuthTokenAndStore("spreddy"));
		this.uri = linkBuilder.toUriComponentsBuilder().toUriString();
		this.message += this.uri;
	}
	
	public UnauthorizedException(String username) {
		this.message = "Hit the Uri to authorize ";
		 WebMvcLinkBuilder
		 linkBuilder = WebMvcLinkBuilder.linkTo(
		 WebMvcLinkBuilder.methodOn(AuthController.class).getAuthTokenAndStore("spreddy"));
		this.uri = linkBuilder.toUriComponentsBuilder().toUriString();
		this.message += this.uri;
	}
	
	
}
