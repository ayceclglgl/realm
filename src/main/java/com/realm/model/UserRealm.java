package com.realm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "realm")
public class UserRealm {
	public static final int KEY_LENGTH = 32;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private String description;
	@Column(length = KEY_LENGTH)
	private String encKey;
	
	
	public UserRealm() {
	}
	
	public UserRealm(Long id, String name, String description, String encKey) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.encKey = encKey;
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

	public String getEncKey() {
		return encKey;
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


	public void setEncKey(String encKey) {
		this.encKey = encKey;
	}

	
	
}
