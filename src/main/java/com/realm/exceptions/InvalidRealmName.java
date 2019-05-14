package com.realm.exceptions;

public class InvalidRealmName extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "InvalidRealmName";

	public InvalidRealmName(){
		super(MESSAGE);
	}

}
