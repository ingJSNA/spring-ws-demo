package com.example.ws.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Address address;
	private String phone;
	private String website;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Company company;
}
