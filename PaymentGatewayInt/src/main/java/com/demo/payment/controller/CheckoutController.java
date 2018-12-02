package com.demo.payment.controller;
/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 2 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.payment.config.AppProperties;
import com.demo.payment.payload.ChargeRequest;

@Controller
public class CheckoutController {

    @Autowired
    private AppProperties appProp;    

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", appProp.getAPI_PUBLIC_KEY());
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}

