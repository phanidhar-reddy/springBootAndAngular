package com.rest.scloud.springCloud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rest.scloud.springCloud.constants.ControllerURIConstants;
import com.rest.scloud.springCloud.constants.TokenConstant;
import com.rest.scloud.springCloud.exceptions.UnauthorizedException;

import reactor.core.publisher.Mono;


@Service
public class UsersServices {

	@Autowired
	WebClient.Builder builder;
	 
	public JsonNode findAllUsers(String username) {
		if ("".equals(TokenConstant.TOKEN))throw new UnauthorizedException(username);
		
		return builder.build()
				.get()
				.uri(ControllerURIConstants.SERVICE_URL+ControllerURIConstants.URI_USERS_JPA.replace("{username}", username))
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
	}

	public void delete(String username, Long id) {
		if ("".equals(TokenConstant.TOKEN))throw new UnauthorizedException(username);
		 builder.build()
				.delete()
				.uri(ControllerURIConstants.SERVICE_URL
						+ControllerURIConstants.URI_USERS_JPA.replace("{username}", username)
						+ControllerURIConstants.URI_ID.replace("{id}", String.valueOf(id)))
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
	}

	public JsonNode findById(String username, Long id) {
		if ("".equals(TokenConstant.TOKEN))throw new UnauthorizedException(username);
		JsonNode jsonNode = 	 builder.build()
				.get()
				.uri(ControllerURIConstants.SERVICE_URL
						+ControllerURIConstants.URI_USERS_JPA.replace("{username}", username)
						+ControllerURIConstants.URI_ID.replace("{id}", String.valueOf(id)))
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
		ObjectNode onode =null;
		if (jsonNode.isObject()) {
			 onode = (ObjectNode) jsonNode;
			 onode.remove("_links");
		}
		return onode;
	}

	public JsonNode save(JsonNode users, String username) {
		if ("".equals(TokenConstant.TOKEN))throw new UnauthorizedException(username);
		return  builder.build()
				.put()
				.uri(ControllerURIConstants.SERVICE_URL
						+ControllerURIConstants.URI_USERS_JPA.replace("{username}", username))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.body(Mono.just(users), JsonNode.class)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
	}
	
	
	public JsonNode update(JsonNode users, String username) {
		if ("".equals(TokenConstant.TOKEN))throw new UnauthorizedException(username);
		return  builder.build()
				.post()
				.uri(ControllerURIConstants.SERVICE_URL
						+ControllerURIConstants.URI_USERS_JPA.replace("{username}", username))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+TokenConstant.TOKEN)
				.body(Mono.just(users), JsonNode.class)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
	}


}
