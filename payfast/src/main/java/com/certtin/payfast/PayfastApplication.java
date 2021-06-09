package com.certtin.payfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PayfastApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayfastApplication.class, args);
	}

}
