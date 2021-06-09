package com.certtin.payfast.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.certtin.payfast.exception.EntityCanNotBeSavedException;
import com.certtin.payfast.mapper.PaymentAPIMapper;
import com.certtin.payfast.model.TransactionMasterDTO;
import com.certtin.payfast.service.PaymentAPIService;
import com.certtin.payfast.util.CertTinUtil;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Slf4j
public class PaymentAPIController {

	@Autowired
	private PaymentAPIService paymentService;
	
	@Autowired
	private PaymentAPIMapper paymentMapper;
	
    @PostMapping("/generate")
    @ResponseBody
    @Operation(summary = "Will generate a transaction in transaction_master status as NEW ")
    public String generateTransaction(@Valid @RequestBody TransactionMasterDTO request) throws EntityCanNotBeSavedException, UnsupportedEncodingException {
    	request.setCerttinPayId(paymentService.addTransactionMaster(paymentMapper.dtoToEntity(request)).getId());
        String redirectUrl = CertTinUtil.toPayfastProcess(request);
        log.info("Redirect URL for Payment gateway : {}", redirectUrl);
        return redirectUrl;
    }
    
    @GetMapping("/redirect")
    @ResponseBody
    @Operation(summary = "Return url for payment gateway, all return variables are sent to notify url only, no data is sent to retutn url")
    public ResponseEntity<String> redirectUrl() {
    	log.info("Redirect URL trigered from payment gateway");
        return new ResponseEntity<String>("Your payment was successful. You was redirected momentarily...", HttpStatus.OK);
    }
    
    @GetMapping("/cancel")
    @ResponseBody
    @Operation(summary = "Cancel url for customer if he cancel the payment flow at any time. Payment gateway will hit back on this url mark transaction_master status as CANCELLED")
    public ResponseEntity<String> cancelUrl() throws IOException {
    	log.info("Payment Cancelled By User");
    	return new ResponseEntity<String>("Payment Cancelled By User", HttpStatus.OK);
    }
    
    @PostMapping("/notify")
    @ResponseBody
    @Operation(summary = "Notify url for payment gateway to send the status back to merchant site, mark transaction_master status as COMPLETE or CANCELLED or INPROGRESS")
    public ResponseEntity<String> notifyUrl(@RequestBody String postData) throws IOException {
    	log.info("ITN data posted from payment gateway : {} ", postData);
    	String paymentStatus = paymentService.updateTransactionMaster(postData);
        return new ResponseEntity<String>("Payment Status :" + paymentStatus, HttpStatus.OK);
    }
    
    @PostMapping("/status")
    @ResponseBody
    @Operation(summary = "Check transaction status with payment gateway i.e PayFast")
    public ResponseEntity<Void> getStatus(@Valid @RequestBody Void property) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @GetMapping("/confirmservice")
    @ResponseBody
    @Operation(summary = "Mark the transaction in transaction_master status as SUCCESS")
    public ResponseEntity<Void> confirmService(@RequestParam Void property) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
