package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// For any exception that may occur in our SpringBoot application -  we need to handle it with custom exception


@ResponseStatus(value = HttpStatus.NOT_FOUND ) // Whenever RESTapi throws ResourceNotFoundException - it will send Not found HTTP status to client
public class ResourceNotFoundException extends RuntimeException{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;  // returns resourceName not found in the DB back to the client
	private String fieldName;
	private Object fieldValue;    // fieldValue can be any type -- reason for object
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue ));  // Super string 
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	
	
	

}
