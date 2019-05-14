package com.realm.exceptions;

public class InvalidArgument extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "InvalidArgument";

	public InvalidArgument(){
		super(MESSAGE);
	}

}
