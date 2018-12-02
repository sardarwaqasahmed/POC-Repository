package com.demo.payment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 2 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private String description;
    private String API_PUBLIC_KEY;
    private String API_PRIVATE_KEY;
    private String API_BASE_URL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAPI_BASE_URL() {
        return API_BASE_URL;
    }

    public void setAPI_BASE_URL(String aPI_BASE_URL) {
        API_BASE_URL = aPI_BASE_URL;
    }

	public String getAPI_PUBLIC_KEY() {
		return API_PUBLIC_KEY;
	}

	public void setAPI_PUBLIC_KEY(String aPI_PUBLIC_KEY) {
		API_PUBLIC_KEY = aPI_PUBLIC_KEY;
	}

	public String getAPI_PRIVATE_KEY() {
		return API_PRIVATE_KEY;
	}

	public void setAPI_PRIVATE_KEY(String aPI_PRIVATE_KEY) {
		API_PRIVATE_KEY = aPI_PRIVATE_KEY;
	}

}
