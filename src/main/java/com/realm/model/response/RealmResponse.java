package com.realm.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "realm")
@JsonPropertyOrder({"id", "name", "description", "key"})
public class RealmResponse {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private String name;
	private String description;
	private String key;
	
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
