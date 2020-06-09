package com.example.rest.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.webservice.model.Todo;
import com.example.rest.webservice.model.Users;
import com.example.rest.webservice.repositries.UserRepository;

@Service
public class UsersServices {
	
	@Autowired
	private UserRepository repository;
	
	public Users save(Users users, String username) {
		return repository.save(users);
	}
	
	public void delete(Long id) {
		Users entity = new Users();
		entity.setId(id);
		repository.delete(entity);
	}
	
	public List<Users> getUserByName(String name){
		return repository.findByName(name);
	}
	
	public Optional<Users> findById(String username, Long id) {
		return repository.findById(id);
	}
	
	
	public List<Users> findAllUsers(){
		return repository.findAll();
	}


}
