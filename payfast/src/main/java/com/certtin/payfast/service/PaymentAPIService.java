/**
 * 
 */
package com.certtin.payfast.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certtin.payfast.entity.TransactionMaster;
import com.certtin.payfast.exception.EntityCanNotBeSavedException;
import com.certtin.payfast.repository.TransactionMasterRepository;
import com.certtin.payfast.util.CertTinUtil;
import static com.certtin.payfast.util.Constants.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
@Service
@Slf4j
public class PaymentAPIService {

	@Autowired
	private TransactionMasterRepository transactionMasterRepository;

	public TransactionMaster addTransactionMaster(TransactionMaster entity) throws EntityCanNotBeSavedException {
		TransactionMaster savedTransaction = transactionMasterRepository.save(entity);
		if (savedTransaction == null || savedTransaction.getId() == null) {
			log.error("TransactionMaster with id {} can not be saved", savedTransaction.getId());
			throw new EntityCanNotBeSavedException("TranscationMasterEntity can not be saved.");
		} else {
			log.info("TransactionMaster with id {} is saved successfully", savedTransaction.getId());
			return savedTransaction;
		}
	}

	public String updateTransactionMaster(String requestUri) {
		Map<String, String> map = CertTinUtil.queryStringToMap(requestUri);
		TransactionMaster updatedTransaction = transactionMasterRepository.findById(Long.parseLong(map.get(M_PAYMENT_ID))).get();
		updatedTransaction.setTrnStatus(map.get(PAYMENT_STATUS));
		updatedTransaction.setPfPaymentId(map.get(PF_PAYMENT_ID));
		updatedTransaction = transactionMasterRepository.save(updatedTransaction);
		updatedTransaction.setUpdatedBy(SYSTEM);
		if (updatedTransaction != null && updatedTransaction.getId() != null) {
            log.info("TransactionMaster with id {} is updated successfully", updatedTransaction.getId());
            return "success";
        } else {
            log.error("TransactionMaster with id {} can not be updated", updatedTransaction.getId());
            return "failure";
        }
	}

}
