package com.example.ws.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.ws.model.User;

@Component
public class TypicodeClient {

	private static final Logger log = LoggerFactory.getLogger(TypicodeClient.class);
	private static final String url = "https://jsonplaceholder.typicode.com/users";

	public List<User> getUsers() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		
		log.info(String.format("Response? %s", response.hasBody()));
		return response.getBody();

	}

}
