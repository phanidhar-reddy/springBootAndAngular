package com.rest.db.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.db.jpa.entity.Users;

/*
 * Using JPA repository
 * JpaRepository has most of the function needed for JPA
 */

public interface UserRepository extends JpaRepository<Users, Long> {
	
	
}
