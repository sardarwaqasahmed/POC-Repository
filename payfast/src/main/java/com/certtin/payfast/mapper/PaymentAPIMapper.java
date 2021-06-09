package com.certtin.payfast.mapper;

import java.util.List;

import com.certtin.payfast.entity.TransactionMaster;
import com.certtin.payfast.model.TransactionMasterDTO;

/**
 * @author c_waqas.ahmad
 * @Date May 22, 2021
 * 
 */
//@Mapper
public interface PaymentAPIMapper {
	
    TransactionMasterDTO entityToDTO(TransactionMaster entity);
    TransactionMaster dtoToEntity(TransactionMasterDTO dto);
    
    List<TransactionMasterDTO> entitesToDTOs(List<TransactionMaster> entites);
}
