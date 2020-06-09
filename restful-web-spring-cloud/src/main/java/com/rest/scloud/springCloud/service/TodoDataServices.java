package com.rest.scloud.springCloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.constants.TokenConstant;
import com.rest.scloud.springCloud.model.JwtTokenResponse;
import com.rest.scloud.springCloud.model.Todo;

import reactor.core.publisher.Mono;

@Service
public class TodoDataServices {
	public static final Logger LOG = LoggerFactory.getLogger(TodoDataServices.class);
	
	@Autowired
	private WebClient.Builder builder;

	
	public List<?> getAllTodosData(String username){
		
		return builder.build()
				.get()
				.uri(ControllerURIConstants.SERVICE_URL+ControllerURIConstants.URI_TODO_JPA.replace("{username}", username))
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.retrieve()
				.bodyToMono(List.class)
				.block();
	}
	
}
