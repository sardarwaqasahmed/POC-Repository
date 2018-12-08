package com.demo.ftl.payload;
/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
public class Attributes {

	private String title;
	private String firstName;
	private String lastName;
	private String age;
	private String homeTown;
	private String country;
	private String phone;
	private String summary;
	
	public Attributes(String title, String firstName, String lastName, String age, String homeTown, String country,
			String phone, String summary) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.homeTown = homeTown;
		this.country = country;
		this.phone = phone;
		this.summary = summary;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
