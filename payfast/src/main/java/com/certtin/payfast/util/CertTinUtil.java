/**
 * 
 */
package com.certtin.payfast.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.web.util.UriComponentsBuilder;

import com.certtin.payfast.model.TransactionMasterDTO;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
public class CertTinUtil {
	
	private static final String SAND_BOX_URL = "https://sandbox.payfast.co.za/eng/process";
//	private static final String SCHEME = "https";
//	private static final String HOST = "sandbox.payfast.co.za";
//	private static final String PATH = "/eng/process";
	
	public static String toPayfastProcess(TransactionMasterDTO request) throws UnsupportedEncodingException {
		
		String redirectURI = UriComponentsBuilder
								    .fromUriString(SAND_BOX_URL)
								    .queryParam("merchant_id", request.getMerchantId())
								    .queryParam("merchant_key", request.getMerchantKey())
								    .queryParam("return_url", request.getReturnUrl())
								    .queryParam("cancel_url", request.getCancelUrl())
								    .queryParam("notify_url", request.getNotifyUrl())
								    .queryParam("name_first", request.getFirstName())
								    .queryParam("name_last", request.getLastName())
								    .queryParam("email_address", request.getEmailAddress())
								    .queryParam("cell_number", request.getPhoneNo())
								    .queryParam("m_payment_id", request.getCerttinPayId())
								    .queryParam("amount", request.getAmount())
								    .queryParam("item_name", request.getItemName())
								    .queryParam("item_description", request.getItemDesc())
								    //.queryParam("email_confirmation", request.getConfirmationAddress())
								    //.queryParam("confirmation_address", request.getConfirmationAddress())
								    .queryParam("currency", request.getCurrency())
								    .queryParam("payment_method", request.getPaymentMethod())
								    //.queryParam("signature", request.getEmailConfirmation())
								    .build().toUriString();
		
		return redirectURI;
	}
	
	public static Map<String, String> queryStringToMap(String requestUri) {
		return Pattern.compile("\\s*&\\s*")
		              .splitAsStream(requestUri.trim())
		              .map(s -> s.split("=", 2))
		              .collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1]: ""));
	}
}
