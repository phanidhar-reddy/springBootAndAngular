package com.rest.scloud.springCloud.constants;

public class ControllerURIConstants {
	
	
	/**
	 * http://localhost:9214
	 * 
	 */
	final public static String SERVICE_URL = "http://localhost:9214";
	
	/**
	 * Authonticate
	 * 
	 */

	final public static String AUTH_URI = "/authenticate";


	/**
	 * Contains Default URI used for todos /user/{username}/todos
	 */
	final public static String URI_TODO = "/user/{username}/todos";
	
	
	/**
	 * Contains Default URI used for todos jpa/user/{username}/todos
	 */
	final public static String URI_TODO_JPA = "/jpa"+URI_TODO;
	
	
	
	/**
	 * Contains Default URI used for todos /user/{username}/users
	 */
	final public static String URI_USERS = "/user/{username}/users";
	
	
	/**
	 * Contains Default URI used for todos jpa/user/{username}/users
	 */
	final public static String URI_USERS_JPA = "/jpa"+URI_USERS;
	
	
	/**
	 * Contains Default URI used Id {id}
	 */
	final public static String URI_ID = "/{id}";
	
	
	/**
	 * Contains Default URI for basic autorization of user from backend
	 */
	final public static String URI_BASE_AUTH = "/basicauth";
	

}
