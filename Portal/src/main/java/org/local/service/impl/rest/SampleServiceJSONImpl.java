package org.local.service.impl.rest;


import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.local.service.SampleService;
import org.local.service.request.Person;
import org.local.utils.RequestHolder;

import com.google.gson.Gson;

@Resource
@Produces("application/json")
public class SampleServiceJSONImpl implements SampleService {

	private static final Logger logger = Logger.getLogger(SampleServiceJSONImpl.class);
	private SampleService sampleService;
	
	private static String JSON_PARAM = "jsonStr";
	
	public SampleService getSampleService() {
		return sampleService;
	}

	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@Override
	@GET
	@Path(value="getName")
	public Person getName(@QueryParam(value = "")Person name) throws Exception {
		return sampleService.getName(name);
	}

	@Override
	@POST
	@Path(value="getNamePost")
	public Person getNamePost(@FormParam(value="")Person person) throws Exception {
		Person request = null;
		String jsonStr = RequestHolder.getRequest().getParameter(JSON_PARAM);
		logger.info("getNamePost request JSON is: " + jsonStr);
		if (jsonStr == null || jsonStr.length() == 0) { 
			throw new Exception("Required Parameter 'jsonStr' is missing in the request. This parameter is JSON representation of Person object.");
		}
		Gson gson = new Gson();
		request = gson.fromJson(jsonStr, Person.class);
		return sampleService.getNamePost(request);
	}

}
