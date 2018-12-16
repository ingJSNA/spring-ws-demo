package com.example.ws.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Operation {

	public static final String ADD = "add";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private OPERATION_TYPE operation;
	private int a;
	private int b;
	private int result;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	/**
	 * @param operation
	 * @param a
	 * @param b
	 * @param result
	 */
	public Operation(OPERATION_TYPE operation, int a, int b, int result) {
		super();
		this.operation = operation;
		this.a = a;
		this.b = b;
		this.result = result;
		this.timestamp = Calendar.getInstance().getTime();
	}
	
	
}
