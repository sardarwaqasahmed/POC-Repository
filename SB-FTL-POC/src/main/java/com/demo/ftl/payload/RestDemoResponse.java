package com.demo.ftl.payload;
/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
public class RestDemoResponse {
	
	private String jsonString;

	public RestDemoResponse(String jsonString) {
		super();
		this.jsonString = jsonString;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	
}