package com.example.rest.webservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloWorldController {

	class HellowWorldBean{ 
		private String message ; 
		@Override
		public String toString() {
			return "HellowWorldBean [message=" + message + "]";
		}
		public HellowWorldBean(String message){
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	@GetMapping(path = "/hellowWorld")
	public String holloWorld() {
		return "Hellow";
	}
	
	@GetMapping(path = "/hellowWorldBean")
	public HellowWorldBean holloWorldBean() {
		return new HellowWorldBean("Hellow");
	}
}
