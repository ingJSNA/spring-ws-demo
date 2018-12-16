package com.example.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ws.model.User;
import com.example.ws.model.UserRepository;
import com.example.ws.rest.TypicodeClient;

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private TypicodeClient client;

	@GetMapping("/users")
	public @ResponseBody Iterable<User> users() {
		repository.deleteAllInBatch();
		
		List<User> users =  client.getUsers();
		
		repository.saveAll(users);
		log.info(String.format("Users: %d", users.size()));
		return repository.findAll();
	}

}
