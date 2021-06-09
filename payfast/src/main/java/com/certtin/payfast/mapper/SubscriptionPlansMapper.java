/**
 * 
 */
package com.certtin.payfast.mapper;

import java.util.List;

import com.certtin.payfast.entity.SubscriptionPlans;
import com.certtin.payfast.model.SubscriptionPlansDTO;

/**
 * @author Ahmed Waqas
 * @Date May 30, 2021
 */
//@Mapper
public interface SubscriptionPlansMapper {

	SubscriptionPlansDTO documentToDTO(SubscriptionPlans doc);
	SubscriptionPlans dtoToDocument(SubscriptionPlansDTO dto);
    
    List<SubscriptionPlansDTO> documentsToDTOs(List<SubscriptionPlans> documents);
}
