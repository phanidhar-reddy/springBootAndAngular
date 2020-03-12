package com.example.rest.webservice.cmdRun;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.rest.webservice.model.Todo;
import com.example.rest.webservice.repositries.ToDoRepository;

@Component
public class CommandLineRunnerGlobal implements CommandLineRunner {
	
	public static final Logger log =  LoggerFactory.getLogger(CommandLineRunnerGlobal.class);
	
	
	@Autowired
	private ToDoRepository todoRepo;
	
	@Override
	public void run(String... args) throws Exception {
		todoRepo.save(new Todo( "spreddy", "Angular", false, new Date()));
		todoRepo.save(new Todo( "spreddy", "Spring", false, new Date()));
		todoRepo.save(new Todo( "spreddy", "Badminton", false, new Date()));
		todoRepo.save(new Todo( "spreddy", "PLSQL", false, new Date()));
		todoRepo.save(new Todo("ranga", "PLSQL", false, new Date()));
	}

}
