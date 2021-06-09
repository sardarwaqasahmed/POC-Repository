/**
 * 
 */
package com.certtin.payfast.controller;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.certtin.payfast.entity.SubscriptionPlans;
import com.certtin.payfast.enums.HttpStatusEnum;
import com.certtin.payfast.mapper.SubscriptionPlansMapper;
import com.certtin.payfast.model.GenericResponse;
import com.certtin.payfast.model.SubscriptionPlansDTO;
import com.certtin.payfast.repository.SubscriptionPlansRepository;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ahmed Waqas
 * @Date May 29, 2021
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Slf4j
public class SubscriptionPlanController {

	@Autowired
	private SubscriptionPlansMapper subscriptionPlansMapper;
	
	@Autowired
	private SubscriptionPlansRepository subPlansRepository;

    @PostMapping("/subcriptionplans")
    @ResponseBody
    @Operation(summary = "Will create a new SubscriptionPlans document.")
	public ResponseEntity<?> createSubscriptionPlan(@Valid @RequestBody SubscriptionPlansDTO subscriptionPlan) {
		try {
			log.debug("calling createSubscriptionPlan(..)");
			subPlansRepository.save(subscriptionPlansMapper.dtoToDocument(subscriptionPlan));
			return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
														  .setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
														  .setResponseMessage("SubscriptionPlans Added Successfully"));
		} catch (Exception e) {
			log.error("Error While Calling createSubscriptionPlan(..) {}", e.getMessage());
			return internalServerError();
		}
	}
	
	@GetMapping("/subcriptionplans")
	@Operation(summary = "Will fetch SubscriptionPlans document by planCode. If no plan code match this api will return all available documents.")
  	public ResponseEntity<?> getAllSubscriptionPlans(@RequestParam(required = false) String planCode ) {
		log.debug("calling getAllSubscriptionPlans(..)");
		try {
			List<SubscriptionPlansDTO> subcriptionPlanList = new ArrayList<SubscriptionPlansDTO>();
			if (isEmpty(planCode)) {
				subcriptionPlanList = subPlansRepository.findAll()
														.stream()
														.map(plan -> subscriptionPlansMapper.documentToDTO(plan))
														.collect(toList());
			} else {
				subPlansRepository.findByPlanCode(planCode)
														.stream()
														.map(plan -> subscriptionPlansMapper.documentToDTO(plan))
														.collect(toList());
			}

			if (subcriptionPlanList.isEmpty()) {
				return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.RECORDS_NOT_FOUND.getCode())
															  .setDeveloperMessage(HttpStatusEnum.RECORDS_NOT_FOUND.getDeveloperMessage())
															  .setResponseMessage("No SubscriptionPlans Found With Given Code"));
			}
			
			return new ResponseEntity<>(subcriptionPlanList, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error While Calling getAllSubscriptionPlans(..) {}", e.getMessage());
			return internalServerError();
		}
	}

	@GetMapping("/subcriptionplans/{id}")
	@Operation(summary = "Will fetch SubscriptionPlans document by id and return unique document.")
	public ResponseEntity<?> getSubscriptionPlanById(@PathVariable("id") String id) {
		log.debug("calling getSubscriptionPlanById(..)");
		Optional<SubscriptionPlans> subscriptionPlanData = subPlansRepository.findById(id);
		if (subscriptionPlanData.isPresent()) {
			return new ResponseEntity<>(subscriptionPlansMapper.documentToDTO(subscriptionPlanData.get()), HttpStatus.OK);
		} else {
			return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.RECORDS_NOT_FOUND.getCode())
														  .setDeveloperMessage(HttpStatusEnum.RECORDS_NOT_FOUND.getDeveloperMessage())
														  .setResponseMessage("No SubscriptionPlans Found With Given Code"));
		}
	}

	@PutMapping("/subcriptionplans/{id}")
	@Operation(summary = "Will update SubscriptionPlans document by id.")
	public ResponseEntity<?> updateSubscriptionPlan(@PathVariable("id") String id, @RequestBody SubscriptionPlansDTO subscriptionPlan) {
		log.debug("calling updateSubscriptionPlan(..)");
		Optional<SubscriptionPlans> subscriptionPlanData = subPlansRepository.findById(id);
		if (subscriptionPlanData.isPresent()) {
			SubscriptionPlans updatedSubscriptionPlan = subscriptionPlanData.get();
			updatedSubscriptionPlan = subscriptionPlansMapper.dtoToDocument(subscriptionPlan);
			subPlansRepository.save(updatedSubscriptionPlan);
			return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
														  .setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
														  .setResponseMessage("SubscriptionPlans Updated Successfully"));
		} else {
			return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.RECORDS_NOT_FOUND.getCode())
														  .setDeveloperMessage(HttpStatusEnum.RECORDS_NOT_FOUND.getDeveloperMessage())
														  .setResponseMessage("No SubscriptionPlans Found With Given Id"));
		}
	}

	@DeleteMapping("/subcriptionplans/{id}")
	@Operation(summary = "Will delete SubscriptionPlans document by id.")
	public ResponseEntity<?> deleteSubscriptionPlan(@PathVariable("id") String id) {
		try {
			log.debug("calling deleteSubscriptionPlan(..)");
			Optional<SubscriptionPlans> subscriptionPlanData = subPlansRepository.findById(id);
			if (subscriptionPlanData.isPresent()) {
				subPlansRepository.deleteById(id);
				return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
															  .setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
															  .setResponseMessage("SubscriptionPlans Deleted Successfully"));
			} else {
				return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.RECORDS_NOT_FOUND.getCode())
															  .setDeveloperMessage(HttpStatusEnum.RECORDS_NOT_FOUND.getDeveloperMessage())
															  .setResponseMessage("No SubscriptionPlans Found With Given Id"));
			}

		} catch (Exception e) {
			log.error("Error While Calling deleteSubscriptionPlan(..) {}", e.getMessage());
			return internalServerError();
		}
	}

	@DeleteMapping("/subcriptionplans")
	@Operation(summary = "Will delete all SubscriptionPlans documents.")
	public ResponseEntity<?> deleteAllSubscriptionPlans() {
		try {
			log.debug("calling deleteAllSubscriptionPlans(..)");
			subPlansRepository.deleteAll();
			return ResponseEntity.ok(new GenericResponse().setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
					  .setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
					  .setResponseMessage("All SubscriptionPlans Deleted Successfully"));
		} catch (Exception e) {
			log.error("Error While Calling deleteAllSubscriptionPlans(..) {}", e.getMessage());
			return internalServerError();
		}
	}
	
	private ResponseEntity<?> internalServerError() {
		return ResponseEntity.ok(new GenericResponse()
							 .setResponseCode(HttpStatusEnum.SERVER_ERROR.getCode())
							 .setDeveloperMessage(HttpStatusEnum.SERVER_ERROR.getDeveloperMessage())
							 .setResponseMessage("Internal Server Error"));
	}
}
