package com.example.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ws.model.CalculatorRepository;
import com.example.ws.model.Operation;
import com.example.ws.soap.CalculatorClient;

@Controller
@RequestMapping(path="/calc")
public class CalculatorController {
	
	private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);
	
	@Autowired
	private CalculatorRepository repository;
	
	@Autowired
	private CalculatorClient client;
	
	@GetMapping("/add")
	public @ResponseBody String addNewCustomer(@RequestParam int a, 
			@RequestParam int b) {
		int result = client.add(a, b); 
		Operation op = new Operation(Operation.ADD, a, b, result);
		log.info("Add operation: "+op);
		repository.save(op);
		return  String.format("%d + %d = %d", a, b, result);
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Operation> getAll() {
		log.info(String.format("Number of operations: %s", repository.count()));
		// This returns a JSON or XML with the operations
		return repository.findAll();
	}

}
