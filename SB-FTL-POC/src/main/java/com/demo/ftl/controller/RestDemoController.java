package com.demo.ftl.controller;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ftl.payload.Attributes;
import com.demo.ftl.payload.Data;
import com.demo.ftl.payload.RestDemoResponse;
import com.demo.ftl.payload.RestRequest;

import freemarker.template.Template;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@RestController
@RequestMapping("/api/rest")
public class RestDemoController {
	
	@Autowired
	@Qualifier("messageSource")
	ResourceBundleMessageSource messageSource;
	
	@Autowired
	@Qualifier("freeMrkTmp")
	freemarker.template.Configuration cfg;
	

	@RequestMapping(value="/showmsg", method=RequestMethod.GET)	
	public String hello(@RequestHeader("Accept-Language") String locale) throws Exception {
		
		Data data = new Data("Demo Page", "Sardar", "WaqasAhmed", "29", "Abbottabad", "Pakistan", "0529386227", "THis is demo for Spring Boot + Freemarker Template + RestController + SpringController + Localization");
		Attributes attributesTitle = new Attributes(messageSource.getMessage("title", null, new Locale(locale)),
				messageSource.getMessage("firstName", null, new Locale(locale)),
				messageSource.getMessage("lastName", null, new Locale(locale)),
				messageSource.getMessage("age", null, new Locale(locale)),
				messageSource.getMessage("homeTown", null, new Locale(locale)),
				messageSource.getMessage("country", null, new Locale(locale)),
				messageSource.getMessage("phone", null, new Locale(locale)),
				messageSource.getMessage("summary", null, new Locale(locale)));
		
		RestRequest request = new RestRequest(data, attributesTitle);
		Template template = cfg.getTemplate("demo.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(getData(request), stringWriter);
		RestDemoResponse response = new RestDemoResponse(stringWriter.toString());

		return response.getJsonString();
	}


	private Map<Object, Object> getData(RestRequest request) {
		Map<Object, Object> input = new HashMap<>();
		input.put("title", request.getAttributesTitle().getTitle());
		input.put("titleData", request.getData().getTitle());
		input.put("firstName", request.getAttributesTitle().getFirstName());
		input.put("firstNameData", request.getData().getFirstName());
		input.put("lastName", request.getAttributesTitle().getLastName());
		input.put("lastNameData", request.getData().getLastName());
		input.put("age", request.getAttributesTitle().getAge());
		input.put("ageData", request.getData().getAge());
		input.put("homeTown", request.getAttributesTitle().getHomeTown());
		input.put("homeTownData", request.getData().getHomeTown());
		input.put("country", request.getAttributesTitle().getCountry());
		input.put("countryData", request.getData().getCountry());
		input.put("phone", request.getAttributesTitle().getPhone());
		input.put("phoneData", request.getData().getPhone());
		input.put("summary", request.getAttributesTitle().getSummary());
		input.put("summaryData", request.getData().getSummary());
		
		return input;
	}
}