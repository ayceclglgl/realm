package com.realm.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RealmRequest {
	
	@NotNull
	@NotEmpty
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

}
