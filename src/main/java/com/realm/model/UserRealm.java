package com.realm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRealm {
	public static final int KEY_LENGTH = 32;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private String description;
	@Column(length = KEY_LENGTH)
	private String key;
	
	
	public UserRealm() {
	}
	
	public UserRealm(Long id, String name, String description, String key) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.key = key;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getKey() {
		return key;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setKey(String key) {
		this.key = key;
	}

	
	
}
