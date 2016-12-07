package org.local.service.impl;

import org.apache.log4j.Logger;
import org.local.service.SampleService;
import org.local.service.request.Person;

public class SampleServiceImpl implements SampleService{
	private static final Logger logger = Logger.getLogger(SampleServiceImpl.class);
	@Override
	public Person getName(Person name) throws Exception {
		logger.info("Request to getName service is: "+name.toString());
		return name;
	}
	@Override
	public Person getNamePost(Person person) throws Exception {
		logger.info("Request to getNamePost service is: "+person.toString());
		
		return person;
	}

}
