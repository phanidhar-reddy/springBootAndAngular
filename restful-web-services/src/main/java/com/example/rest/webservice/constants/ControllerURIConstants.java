package com.example.rest.webservice.constants;

public class ControllerURIConstants {

	/**
	 * Contains Default URI used for todos /user/{username}/todos
	 */
	final public static String URI_TODO = "/user/{username}/todos";
	
	
	/**
	 * Contains Default URI used for todos jpa/user/{username}/todos
	 */
	final public static String URI_TODO_JPA = "/jpa"+URI_TODO;
	
	/**
	 * Contains Default URI used Id {id}
	 */
	final public static String URI_ID = "/{id}";
	
	
	/**
	 * Contains Default URI for basic autorization of user from backend
	 */
	final public static String URI_BASE_AUTH = "/basicauth";
	
}
