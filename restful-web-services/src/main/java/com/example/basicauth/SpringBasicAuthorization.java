package com.example.basicauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // defining that this is a config file 
@EnableWebSecurity // telling that this is for web securtity
public class SpringBasicAuthorization extends WebSecurityConfigurerAdapter{

	
	/**
	 * Override this method to configure the {@link HttpSecurity}. Typically subclasses
	 * should not invoke this method by calling super as it may override their
	 * configuration. The default configuration is:
	 *
	 * <pre>
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	 * </pre>
	 *
	 * @param http the {@link HttpSecurity} to modify
	 * @throws Exception if an error occurs
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable() //disabling csrf 
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
			/*
			 * method the HttpMethod to use or null for any HttpMethod.
			 * antPatterns the ant patterns to create. If null or empty, then matches on nothing. 
			 */
			.anyRequest() //Maps any request.
			.authenticated()
			.and()
			.httpBasic(); //http basic type auth
	}
	
}
