package com.demo.payment.service;

import com.demo.payment.payload.ChargeRequest;
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
public interface StripeService {
	Charge charge(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
}
