package com.example.ws.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@lombok.NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Geo geo;
}
