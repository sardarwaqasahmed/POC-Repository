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



@Produces("text/plain")

public class HelloServiceImpl {
	
	
	private static final Logger logger = Logger.getLogger(HelloServiceImpl.class);
	@GET
	@Path(value="helloService")
	public String HelloService(@QueryParam("name")String name1) throws Exception {
		
		logger.info("In the helo service method");
		
		return "HELLO SERVICE sayas hello to: " +name1;
		
	}
	

	


}
