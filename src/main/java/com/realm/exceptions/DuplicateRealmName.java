package com.realm.exceptions;

public class DuplicateRealmName extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "DuplicateRealmName";
	
	public DuplicateRealmName(){
		super(MESSAGE);
	}

}
