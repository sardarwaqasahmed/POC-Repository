package com.demo.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.demo.payment.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class PaymentGatewayIntApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayIntApplication.class, args);
	}
}
