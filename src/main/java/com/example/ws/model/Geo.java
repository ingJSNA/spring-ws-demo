package com.example.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@lombok.NoArgsConstructor
public class Geo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private double lat;
	private double lng;
}
