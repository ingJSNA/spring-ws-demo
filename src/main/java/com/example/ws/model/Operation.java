package com.example.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Operation {

	public static final String ADD = "add";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String operation;
	private int a;
	private int b;
	private int result;

	/**
	 * @param operation
	 * @param a
	 * @param b
	 * @param result
	 */
	public Operation(String operation, int a, int b, int result) {
		super();
		this.operation = operation;
		this.a = a;
		this.b = b;
		this.result = result;
	}
	
	
}
