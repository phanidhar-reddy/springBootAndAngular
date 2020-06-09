package com.example.rest.webservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hellowWorld")
	public String holloWorld() {
		return "Hellow";
	}
	
	@GetMapping(path = "/hellowWorldBean/international")
	public String holloWorldBean() {
		return messageSource.getMessage("good.morning.message", null, 
				LocaleContextHolder.getLocale());
	}
}
