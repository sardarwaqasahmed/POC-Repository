/**
 * 
 */
package com.certtin.payfast.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.certtin.payfast.entity.SubscriptionPlans;

/**
 * @author Ahmed Waqas
 * @Date May 29, 2021
 */
public interface SubscriptionPlansRepository extends MongoRepository<SubscriptionPlans, String> {

	/**
	 * @param planCode
	 * @return
	 */
	List<SubscriptionPlans> findByPlanCode(String planCode);

}
