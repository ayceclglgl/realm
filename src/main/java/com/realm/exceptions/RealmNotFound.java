package com.realm.exceptions;

public class RealmNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "RealmNotFound";

	public RealmNotFound(){
		super(MESSAGE);
	}

}
