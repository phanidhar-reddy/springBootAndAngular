package com.rest.db.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.db.jpa.entity.Users;

/*
 * Not using Spring Data JPA
 */

@Repository // used to access the databse
@Transactional //transaction says each method will be put in a transaction 
public class UserDaoServices {
	
	@PersistenceContext //persistance to save chnages and track them 
	/*
	 * 	Users jack = new Users("jack", "Admin", "73189238");
	 * 	Users jill = new Users("jill", "System", "73189238");
	 * 
	*  entityManager.persist(jack);
	*  jack.setRole("User") // tracked by the @PersistenceContext
	*  jill.setRole("User") // not tracked by @PersistenceContext
	 * 
	 */
	private EntityManager entityManager;
	
	public long insertUserData(Users user) {
	
		entityManager.persist(user);
		return user.getId();
		
	}
	
}
