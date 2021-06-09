package com.certtin.payfast.mapper;

import static com.certtin.payfast.util.Constants.ADVANCE_SIGHTS;
import static com.certtin.payfast.util.Constants.BASIC_MOBILITY_REPORTING;
import static com.certtin.payfast.util.Constants.BLOCKCHAIN_VERIFICATION;
import static com.certtin.payfast.util.Constants.BULK_ISSUANCE;
import static com.certtin.payfast.util.Constants.CUSTOM_INTEGRATION;
import static com.certtin.payfast.util.Constants.DEDICATED_ACCOUNT_MANAGER;
import static com.certtin.payfast.util.Constants.DIGITAL_SKILLS_WALLET;
import static com.certtin.payfast.util.Constants.HOSTED_URL;
import static com.certtin.payfast.util.Constants.LEAD_GENERATION;
import static com.certtin.payfast.util.Constants.MULTI_CHANNEL;
import static com.certtin.payfast.util.Constants.PERSONALIZED_URL;
import static com.certtin.payfast.util.Constants.PRODUCT_ROADMAP;
import static com.certtin.payfast.util.Constants.WHITE_LABELLING;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import static org.springframework.util.ObjectUtils.isEmpty;

import com.certtin.payfast.entity.SubscriptionPlans;
import com.certtin.payfast.model.SubscriptionPlansDTO;

@Component
public class SubscriptionPlansMapperImpl implements SubscriptionPlansMapper {

    @Override
    public SubscriptionPlansDTO documentToDTO(SubscriptionPlans doc) {
        if ( doc == null ) {
            return null;
        }

        SubscriptionPlansDTO subscriptionPlansDTO = new SubscriptionPlansDTO();
        subscriptionPlansDTO.setId(doc.getId());
        subscriptionPlansDTO.setPlanName( doc.getPlanName() );
        subscriptionPlansDTO.setPlanCode( doc.getPlanCode() );
        subscriptionPlansDTO.setMonthlySubAmtUsd( doc.getMonthlySubAmtUsd() );
        subscriptionPlansDTO.setAnnualSubAmtUsd( doc.getAnnualSubAmtUsd() );
        subscriptionPlansDTO.setMonthlySubAmtZar( doc.getMonthlySubAmtZar() );
        subscriptionPlansDTO.setAnnualSubAmtZar( doc.getAnnualSubAmtZar() );
        subscriptionPlansDTO.setMinimumDuration( doc.getMinimumDuration() );
        subscriptionPlansDTO.setNoOfFreeMonth( doc.getNoOfFreeMonth() );
        subscriptionPlansDTO.setMonthlyPremiumZar( doc.getMonthlyPremiumZar() );
        subscriptionPlansDTO.setAnnualPremiumZar( doc.getAnnualPremiumZar() );
        subscriptionPlansDTO.setBaseCategory( doc.getBaseCategory() );
        subscriptionPlansDTO.setPlanValidity( doc.getPlanValidity() );
        subscriptionPlansDTO.setAllowedOrgCount( doc.getAllowedOrgCount() );
        subscriptionPlansDTO.setAllowedAdminUserCount( doc.getAllowedAdminUserCount() );
        subscriptionPlansDTO.setAllowedTemplateCount( doc.getAllowedTemplateCount() );
        
        subscriptionPlansDTO.setIsBlockChainVerification( doc.getIsBlockChainVerification() );
        subscriptionPlansDTO.setIsDigitalSkillsWallet( doc.getIsDigitalSkillsWallet() );
        subscriptionPlansDTO.setIsMultiChannel( doc.getIsMultiChannel() );
        subscriptionPlansDTO.setIsBulkIssuance( doc.getIsBulkIssuance() );
        subscriptionPlansDTO.setIsHostedUrl( doc.getIsHostedUrl() );
        subscriptionPlansDTO.setIsPersonalisedUrl( doc.getIsPersonalisedUrl() );
        subscriptionPlansDTO.setIsBasicMobilityReporting( doc.getIsBasicMobilityReporting() );
        subscriptionPlansDTO.setIsLeadGeneration( doc.getIsLeadGeneration() );
        subscriptionPlansDTO.setIsAdvanceSights( doc.getIsAdvanceSights() );
        subscriptionPlansDTO.setIsWhiteLabelling( doc.getIsWhiteLabelling() );
        subscriptionPlansDTO.setIsCustomIntegration( doc.getIsCustomIntegration() );
        subscriptionPlansDTO.setIsProductRoadMap( doc.getIsProductRoadMap() );
        subscriptionPlansDTO.setIsDedicatedAccountManager( doc.getIsDedicatedAccountManager() );

        subscriptionPlansDTO.setCreatedDate( doc.getCreatedDate() );
        subscriptionPlansDTO.setCreatedBy( doc.getCreatedBy() );
        subscriptionPlansDTO.setUpdatedDate( doc.getUpdatedDate() );
        subscriptionPlansDTO.setUpdatedBy( doc.getUpdatedBy() );

        if(!isEmpty(doc.getIsBlockChainVerification()) && doc.getIsBlockChainVerification()) {
        	subscriptionPlansDTO.getFeaturesList().add(BLOCKCHAIN_VERIFICATION);
        }
        if(!isEmpty(doc.getIsDigitalSkillsWallet()) && doc.getIsDigitalSkillsWallet()) {
        	subscriptionPlansDTO.getFeaturesList().add(DIGITAL_SKILLS_WALLET);
        }
        if(!isEmpty(doc.getIsMultiChannel()) && doc.getIsMultiChannel()) {
        	subscriptionPlansDTO.getFeaturesList().add(MULTI_CHANNEL);
        }
        if(!isEmpty(doc.getIsBulkIssuance()) && doc.getIsBulkIssuance()) {
        	subscriptionPlansDTO.getFeaturesList().add(BULK_ISSUANCE);
        }
        if(!isEmpty(doc.getIsHostedUrl()) && doc.getIsHostedUrl()) {
        	subscriptionPlansDTO.getFeaturesList().add(HOSTED_URL);
        }
        if(!isEmpty(doc.getIsPersonalisedUrl()) && doc.getIsPersonalisedUrl()) {
        	subscriptionPlansDTO.getFeaturesList().add(PERSONALIZED_URL);
        }
        if(!isEmpty(doc.getIsBasicMobilityReporting()) && doc.getIsBasicMobilityReporting()) {
        	subscriptionPlansDTO.getFeaturesList().add(BASIC_MOBILITY_REPORTING);
        }
        if(!isEmpty(doc.getIsLeadGeneration()) && doc.getIsLeadGeneration()) {
        	subscriptionPlansDTO.getFeaturesList().add(LEAD_GENERATION);
        }
        if(!isEmpty(doc.getIsAdvanceSights()) && doc.getIsAdvanceSights()) {
        	subscriptionPlansDTO.getFeaturesList().add(ADVANCE_SIGHTS);
        }
        if(!isEmpty(doc.getIsWhiteLabelling()) && doc.getIsWhiteLabelling()) {
        	subscriptionPlansDTO.getFeaturesList().add(WHITE_LABELLING);
        }
        if(!isEmpty(doc.getIsCustomIntegration()) && doc.getIsCustomIntegration()) {
        	subscriptionPlansDTO.getFeaturesList().add(CUSTOM_INTEGRATION);
        }
        if(!isEmpty(doc.getIsProductRoadMap()) && doc.getIsProductRoadMap()) {
        	subscriptionPlansDTO.getFeaturesList().add(PRODUCT_ROADMAP);
        }
        if(!isEmpty(doc.getIsDedicatedAccountManager()) && doc.getIsDedicatedAccountManager()) {
        	subscriptionPlansDTO.getFeaturesList().add(DEDICATED_ACCOUNT_MANAGER);
        }

        return subscriptionPlansDTO;
    }

    @Override
    public SubscriptionPlans dtoToDocument(SubscriptionPlansDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubscriptionPlans subscriptionPlans = new SubscriptionPlans();
        subscriptionPlans.setId(dto.getId());
        subscriptionPlans.setPlanName( dto.getPlanName() );
        subscriptionPlans.setPlanCode( dto.getPlanCode() );
        subscriptionPlans.setMonthlySubAmtUsd( dto.getMonthlySubAmtUsd() );
        subscriptionPlans.setAnnualSubAmtUsd( dto.getAnnualSubAmtUsd() );
        subscriptionPlans.setMonthlySubAmtZar( dto.getMonthlySubAmtZar() );
        subscriptionPlans.setAnnualSubAmtZar( dto.getAnnualSubAmtZar() );
        subscriptionPlans.setMinimumDuration( dto.getMinimumDuration() );
        subscriptionPlans.setNoOfFreeMonth( dto.getNoOfFreeMonth() );
        subscriptionPlans.setMonthlyPremiumZar( dto.getMonthlyPremiumZar() );
        subscriptionPlans.setAnnualPremiumZar( dto.getAnnualPremiumZar() );
        subscriptionPlans.setBaseCategory( dto.getBaseCategory() );
        subscriptionPlans.setPlanValidity( dto.getPlanValidity() );
        subscriptionPlans.setAllowedOrgCount( dto.getAllowedOrgCount() );
        subscriptionPlans.setAllowedAdminUserCount( dto.getAllowedAdminUserCount() );
        subscriptionPlans.setAllowedTemplateCount( dto.getAllowedTemplateCount() );
        subscriptionPlans.setIsBlockChainVerification( dto.getIsBlockChainVerification() );
        subscriptionPlans.setIsDigitalSkillsWallet( dto.getIsDigitalSkillsWallet() );
        subscriptionPlans.setIsMultiChannel( dto.getIsMultiChannel() );
        subscriptionPlans.setIsBulkIssuance( dto.getIsBulkIssuance() );
        subscriptionPlans.setIsHostedUrl( dto.getIsHostedUrl() );
        subscriptionPlans.setIsPersonalisedUrl( dto.getIsPersonalisedUrl() );
        subscriptionPlans.setIsBasicMobilityReporting( dto.getIsBasicMobilityReporting() );
        subscriptionPlans.setIsLeadGeneration( dto.getIsLeadGeneration() );
        subscriptionPlans.setIsAdvanceSights( dto.getIsAdvanceSights() );
        subscriptionPlans.setIsWhiteLabelling( dto.getIsWhiteLabelling() );
        subscriptionPlans.setIsCustomIntegration( dto.getIsCustomIntegration() );
        subscriptionPlans.setIsProductRoadMap( dto.getIsProductRoadMap() );
        subscriptionPlans.setIsDedicatedAccountManager( dto.getIsDedicatedAccountManager() );
        subscriptionPlans.setCreatedDate( dto.getCreatedDate() );
        subscriptionPlans.setCreatedBy( dto.getCreatedBy() );
        subscriptionPlans.setUpdatedDate( dto.getUpdatedDate() );
        subscriptionPlans.setUpdatedBy( dto.getUpdatedBy() );

        return subscriptionPlans;
    }

    @Override
    public List<SubscriptionPlansDTO> documentsToDTOs(List<SubscriptionPlans> documents) {
        if ( documents == null ) {
            return null;
        }

        List<SubscriptionPlansDTO> list = new ArrayList<SubscriptionPlansDTO>( documents.size() );
        for ( SubscriptionPlans subscriptionPlans : documents ) {
            list.add( documentToDTO( subscriptionPlans ) );
        }

        return list;
    }
}
