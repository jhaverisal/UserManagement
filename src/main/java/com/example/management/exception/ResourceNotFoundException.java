package com.example.management.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int resourceId;

	public ResourceNotFoundException(int resourceId, String msg) {
		super(msg);
		this.resourceId = resourceId;
	}
	
	

}
