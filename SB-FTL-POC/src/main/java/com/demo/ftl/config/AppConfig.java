package com.demo.ftl.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@Configuration
public class AppConfig {	
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rbMessageSource = new ResourceBundleMessageSource();
		rbMessageSource.setBasename("messages");
		rbMessageSource.setFallbackToSystemLocale(false);
		rbMessageSource.setCacheSeconds(0);
		rbMessageSource.setDefaultEncoding("UTF-8");
		rbMessageSource.setUseCodeAsDefaultMessage(true);
		return rbMessageSource;
	}
	
	@Bean("freeMrkTmp")
	freemarker.template.Configuration freeMarkerConfiguration() {
		Version version = new Version("2.3.27");
		freemarker.template.Configuration cfg = new freemarker.template.Configuration(version);
		cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
		return cfg;
	}
}
