package com.realm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.realm.exceptions.DuplicateRealmName;
import com.realm.exceptions.InvalidArgument;
import com.realm.exceptions.InvalidRealmName;
import com.realm.exceptions.RealmNotFound;
import com.realm.model.response.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(value = { DuplicateRealmName.class, InvalidRealmName.class, InvalidArgument.class })
	protected ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { RealmNotFound.class })
	protected ResponseEntity<ErrorResponse> handleNotFoundException(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
	
}
