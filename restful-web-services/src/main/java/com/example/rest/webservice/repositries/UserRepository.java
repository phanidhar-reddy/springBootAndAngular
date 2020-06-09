package com.example.rest.webservice.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservice.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	List<Users> findByName(String name);
	
}
