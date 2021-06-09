/**
 * 
 */
package com.certtin.payfast.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * @author Ahmed Waqas
 * @Date May 29, 2021
 */
@Document(collection = "subscriptionplans")
@Data
public class SubscriptionPlans {

	@Id
	private String id;
	@Field
	private String planName;
	@Indexed(unique = true)
	@Field
	private String planCode;
	@Field
	private String monthlySubAmtUsd;
	@Field
	private String annualSubAmtUsd;
	@Field
	private String monthlySubAmtZar;
	@Field
	private String annualSubAmtZar;
	@Field
	private String minimumDuration;
	@Field
	private String noOfFreeMonth;
	@Field
	private String monthlyPremiumZar;
	@Field
	private String annualPremiumZar;
	@Field
	private String baseCategory;
	@Field
	private String planValidity;
	@Field
	private String allowedOrgCount;
	@Field
	private String allowedAdminUserCount;
	@Field
	private String allowedTemplateCount;
	@Field
	private Boolean isBlockChainVerification;
	@Field
	private Boolean isDigitalSkillsWallet;
	@Field
	private Boolean isMultiChannel;
	@Field
	private Boolean isBulkIssuance;
	@Field
	private Boolean isHostedUrl;
	@Field
	private Boolean isPersonalisedUrl;
	@Field
	private Boolean isBasicMobilityReporting;
	@Field
	private Boolean isLeadGeneration;
	@Field
	private Boolean isAdvanceSights;
	@Field
	private Boolean isWhiteLabelling;
	@Field
	private Boolean isCustomIntegration;
	@Field
	private Boolean isProductRoadMap;
	@Field
	private Boolean isDedicatedAccountManager;
	@Field
	private String createdDate;
	@Field
	private String createdBy;
	@Field
	private String updatedDate;
	@Field
	private String updatedBy;
//	private List<Document> templateArrays;
}
