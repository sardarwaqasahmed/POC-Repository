package org.local.service;

import javax.jws.WebService;

import org.local.service.request.Person;

@WebService
public interface SampleService {

	public Person getName(Person name) throws Exception;
	
	public Person getNamePost(Person person) throws Exception;
}
