package com.example.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ws.model.CalculatorRepository;
import com.example.ws.model.OPERATION_TYPE;
import com.example.ws.model.Operation;
import com.example.ws.model.User;
import com.example.ws.model.UserRepository;
import com.example.ws.rest.TypicodeClient;
import com.example.ws.soap.CalculatorClient;

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
		
		return repository.findAll();
	}

}
