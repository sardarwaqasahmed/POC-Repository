package com.certtin.payfast.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class TransactionMasterDTO {

	private Long certtinPayId;
	
    @NotNull
    @NotBlank
    private String returnUrl;

    @NotNull
    @NotBlank
    private String cancelUrl;

    @NotNull
    @NotBlank
    private String notifyUrl;
    
    @NotNull
    @NotBlank
    private String merchantId;

    @NotNull
    @NotBlank
    private String merchantKey;
    
    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String emailAddress;

    @NotNull
    @NotBlank
    private String confirmationAddress;
    
    
    @NotNull
    @NotBlank
    private String phoneNo;
    
    @NotNull
    @NotBlank    
    private String itemName;
    
    @NotNull
    @NotBlank    
    private String itemDesc;
    
    @NotNull
    @NotBlank
    private BigDecimal amount;
    
    @NotNull
    @NotBlank
    private String currency;
    
    @NotNull
    @NotBlank
    private String paymentMethod;
    
    @NotNull
    @NotBlank
    private String trnStatus;
    
    private int emailConfirmation;
}
