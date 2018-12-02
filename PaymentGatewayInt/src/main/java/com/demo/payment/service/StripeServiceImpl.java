package com.demo.payment.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.payment.config.AppProperties;
import com.demo.payment.payload.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 2 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@Service
public class StripeServiceImpl implements StripeService {

    @Autowired
    private AppProperties appProp;  

	@PostConstruct
	public void init() {
		Stripe.apiKey = appProp.getAPI_PRIVATE_KEY();
	}
	    
	@Override
	public Charge charge(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", chargeRequest.getAmount());
		chargeParams.put("currency", chargeRequest.getCurrency());
		chargeParams.put("description", chargeRequest.getDescription());
		chargeParams.put("source", chargeRequest.getStripeToken());
		return Charge.create(chargeParams);
	}
}
