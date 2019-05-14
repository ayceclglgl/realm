package com.realm.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "error")
public class ErrorResponse {
	
	private String code;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
