package com.demo.ftl.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.ftl.payload.Attributes;
import com.demo.ftl.payload.Data;
import com.demo.ftl.payload.SpringMVCDemoResponse;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@Controller
@RequestMapping("/api/mvc")
public class SpringMVCDemoController {
	
	@Autowired
	@Qualifier("messageSource")
	ResourceBundleMessageSource messageSource;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/demo")
	public String hello(Model model,@RequestParam(value = "locale", required = false, defaultValue = "en") String locale) {
		
		Data data = new Data("Demo Page", "Sardar", "WaqasAhmed", "29", "Abbottabad", "Pakistan", "0529386227", "THis is demo for Spring Boot + Freemarker Template + RestController + SpringController + Localization");
		Attributes title = new Attributes(messageSource.getMessage("title", null, new Locale(locale)),
				messageSource.getMessage("firstName", null, new Locale(locale)),
				messageSource.getMessage("lastName", null, new Locale(locale)),
				messageSource.getMessage("age", null, new Locale(locale)),
				messageSource.getMessage("homeTown", null, new Locale(locale)),
				messageSource.getMessage("country", null, new Locale(locale)),
				messageSource.getMessage("phone", null, new Locale(locale)),
				messageSource.getMessage("summary", null, new Locale(locale)));
		SpringMVCDemoResponse response = new SpringMVCDemoResponse(data,title);
		getData(model, response);	
		
		return "demo";
	}
	
	private void getData(Model model, SpringMVCDemoResponse response) {
		model.addAttribute("title", response.getAttributesTitle().getTitle());
		model.addAttribute("titleData", response.getData().getTitle());
		model.addAttribute("firstName", response.getAttributesTitle().getFirstName());
		model.addAttribute("firstNameData", response.getData().getFirstName());
		model.addAttribute("lastName", response.getAttributesTitle().getLastName());
		model.addAttribute("lastNameData", response.getData().getLastName());
		model.addAttribute("age", response.getAttributesTitle().getAge());
		model.addAttribute("ageData", response.getData().getAge());
		model.addAttribute("homeTown", response.getAttributesTitle().getHomeTown());
		model.addAttribute("homeTownData", response.getData().getHomeTown());
		model.addAttribute("country", response.getAttributesTitle().getCountry());
		model.addAttribute("countryData", response.getData().getCountry());
		model.addAttribute("phone", response.getAttributesTitle().getPhone());
		model.addAttribute("phoneData", response.getData().getPhone());
		model.addAttribute("summary", response.getAttributesTitle().getSummary());
		model.addAttribute("summaryData", response.getData().getSummary());
	}
}
