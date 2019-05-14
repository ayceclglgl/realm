package com.realm.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.realm.converters.UserRealmToRealmResponse;
import com.realm.exceptions.InvalidArgument;
import com.realm.exceptions.InvalidRealmName;
import com.realm.model.UserRealm;
import com.realm.model.request.RealmRequest;
import com.realm.model.response.RealmResponse;
import com.realm.service.RealmService;

@RestController
public class RealmController {

	RealmService service;
	UserRealmToRealmResponse userRealmToRealmResponse;

	public RealmController(RealmService service, UserRealmToRealmResponse userRealmToRealmResponse) {
		this.service = service;
		this.userRealmToRealmResponse = userRealmToRealmResponse;
	}

	@PostMapping(path = "/service/user/realm", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<RealmResponse> createRealm(@RequestBody @Valid RealmRequest realm, BindingResult bindingResult, 
			@RequestHeader("content-type") String contentType) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRealmName(); // since validation is just on name field
		}

		// TODO: do it in a nice way!!
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", contentType);

		UserRealm userRealm = service.createRealm(realm.getName(), realm.getDescription());
		return new ResponseEntity<>(userRealmToRealmResponse.convert(userRealm), headers, HttpStatus.CREATED);
	}

	
	@GetMapping(path = "/service/user/realm/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<RealmResponse> getRealm(@PathVariable("id") String id) {
		Long longId;
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new InvalidArgument();
		}

		UserRealm userRealm = service.getById(longId);
		return new ResponseEntity<>(userRealmToRealmResponse.convert(userRealm), HttpStatus.OK);
	}

}
