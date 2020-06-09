package com.rest.scloud.springCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.constants.TokenConstant;
import com.rest.scloud.springCloud.model.JwtTokenRequest;
import com.rest.scloud.springCloud.model.JwtTokenResponse;

import reactor.core.publisher.Mono;

@Service
public class AuthorzationServices {

	@Autowired
	private WebClient.Builder builder;
	
	private JsonNode getAuthService(String username , String password){
			
			JwtTokenRequest tokenRequest =new JwtTokenRequest(username, password); 
			
			return builder.build()
			.post()
			.uri(ControllerURIConstants.SERVICE_URL+ControllerURIConstants.AUTH_URI)
			.bodyValue(tokenRequest)
			.retrieve()
			.bodyToMono(JsonNode.class)
			.block();
		}

	public void getAuthService(String username) {
	
		  JsonNode tokenResponse = getAuthService(username,
		  "1234"); 
		  TokenConstant.TOKEN = tokenResponse.get("token").asText();
		 
	}
}
