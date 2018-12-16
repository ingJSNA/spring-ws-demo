package com.example.ws.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@lombok.NoArgsConstructor
public class User {
	
	@Id
	private long id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
}
