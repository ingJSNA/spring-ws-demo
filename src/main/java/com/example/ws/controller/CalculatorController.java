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
import com.example.ws.model.OPERATION_TYPE;
import com.example.ws.model.Operation;
import com.example.ws.soap.CalculatorClient;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {

	private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	private CalculatorRepository repository;

	@Autowired
	private CalculatorClient client;

	@GetMapping("/op")
	public @ResponseBody String add(@RequestParam String operation, @RequestParam int a,
			@RequestParam int b) {
		int result = 0;
		OPERATION_TYPE operationType;
		switch (operation) {
		case "add":
			result = client.add(a, b);
			operationType = OPERATION_TYPE.ADD;
			break;
		case "divide":
			result = client.divide(a, b);
			operationType = OPERATION_TYPE.DIVIDE;
			break;
		case "multiply":
			result = client.multiply(a, b);
			operationType = OPERATION_TYPE.MULTIPLY;
			break;
		case "subtract":
			result = client.subtract(a, b);
			operationType = OPERATION_TYPE.SUBTRACT;
			break;

		default:
			return "Operación desconocida";
		}
		Operation op = new Operation(operationType, a, b, result);
		log.info("Operation: " + op);
		repository.save(op);
		return String.format("%d %s %d = %d", a, operationType, b, result);
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<Operation> getAll() {
		log.info(String.format("Number of operations: %s", repository.count()));
		// This returns a JSON or XML with the operations
		return repository.findAll();
	}

}
