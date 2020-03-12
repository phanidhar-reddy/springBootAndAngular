package com.rest.db.jpa.cmdRun;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.db.jpa.entity.Users;
import com.rest.db.jpa.service.UserDaoServices;
import com.rest.db.jpa.service.UserRepository;

@Component
public class UserServiceCumRun implements CommandLineRunner {
	public static final Logger log =  LoggerFactory.getLogger(UserServiceCumRun.class);
	@Autowired
	private UserDaoServices userDaoServices;
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		Users jack = new Users("jack", "Admin", "73189238");
		Users jill = new Users("jill", "System", "73189238");
		
		log.info(String.valueOf(userDaoServices.insertUserData(jack)));
		log.info(String.valueOf(userRepo.save(jill)));
	}

}
