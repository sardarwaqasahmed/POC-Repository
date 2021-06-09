package com.certtin.payfast.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certtin.payfast.entity.TransactionMaster;
/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
@Repository
public interface TransactionMasterRepository extends CrudRepository<TransactionMaster, Long> {

}
