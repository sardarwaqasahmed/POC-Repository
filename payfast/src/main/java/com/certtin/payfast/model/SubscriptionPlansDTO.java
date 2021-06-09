/**
 * 
 */
package com.certtin.payfast.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ahmed Usman
 * @Date May 30, 2021
 */
@Getter
@Setter
@Data
public class SubscriptionPlansDTO {

	private String id;
    @NotNull
    @NotBlank
	private String planName;
    @NotNull
    @NotBlank
    private String planCode;
    @NotNull
    @NotBlank
    private String monthlySubAmtUsd;
    @NotNull
    @NotBlank
    private String annualSubAmtUsd;
    @NotNull
    @NotBlank
	private String minimumDuration;
    @NotNull
    @NotBlank
    private String noOfFreeMonth;    
    @NotNull
    @NotBlank
	private String planValidity;
    @NotNull
    @NotBlank
    private String allowedOrgCount;
    @NotNull
    @NotBlank
    private String allowedAdminUserCount;
    @NotNull
    @NotBlank
    private String allowedTemplateCount;
    private String monthlySubAmtZar;
	private String annualSubAmtZar;
	private String monthlyPremiumZar;
	private String annualPremiumZar;
	private String baseCategory;
	
	private Boolean isBlockChainVerification;
	private Boolean isDigitalSkillsWallet;
	private Boolean isMultiChannel;
	private Boolean isBulkIssuance;
	private Boolean isHostedUrl;
	private Boolean isPersonalisedUrl;
	private Boolean isBasicMobilityReporting;
	private Boolean isLeadGeneration;
	private Boolean isAdvanceSights;
	private Boolean isWhiteLabelling;
	private Boolean isCustomIntegration;
	private Boolean isProductRoadMap;
	private Boolean isDedicatedAccountManager;
	
	private List<String> featuresList = new ArrayList<>();
	
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
}
