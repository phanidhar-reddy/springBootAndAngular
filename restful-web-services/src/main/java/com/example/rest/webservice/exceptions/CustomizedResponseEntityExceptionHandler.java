package com.example.rest.webservice.exceptions;

import java.util.Date;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler 
				extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)//what type of exceptions needs trtoo be handled
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ResponseExceptions responseExceptions = new ResponseExceptions(new Date(), ex.getMessage(), request.getDescription(false)); //createing details for exceptrion
		return new ResponseEntity(responseExceptions,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@ExceptionHandler(UserNotFoundException.class)//what type of exceptions needs trtoo be handled
	public final ResponseEntity<Object> handleUserNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
		ResponseExceptions responseExceptions = new ResponseExceptions(new Date(), ex.getMessage(), request.getDescription(false)); //createing details for exceptrion
		return new ResponseEntity(responseExceptions,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseExceptions responseExceptions = new ResponseExceptions(new Date()
				, "Validation Failed", ex.getBindingResult().toString()); //createing details for exceptrion
		return new ResponseEntity(responseExceptions,HttpStatus.NOT_FOUND);
	}
	
}
