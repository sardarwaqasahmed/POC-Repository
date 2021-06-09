package com.certtin.payfast.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.certtin.payfast.entity.TransactionMaster;
import com.certtin.payfast.entity.TransactionMaster.TransactionMasterBuilder;
import com.certtin.payfast.model.TransactionMasterDTO;
import com.certtin.payfast.model.TransactionMasterDTO.TransactionMasterDTOBuilder;
import static com.certtin.payfast.util.Constants.*;

@Component
public class PaymentAPIMapperImpl implements PaymentAPIMapper {

    @Override
    public TransactionMasterDTO entityToDTO(TransactionMaster entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionMasterDTOBuilder transactionMasterDTO = TransactionMasterDTO.builder();

        transactionMasterDTO.firstName( entity.getFirstName() );
        transactionMasterDTO.lastName( entity.getLastName() );
        transactionMasterDTO.emailAddress( entity.getEmailAddress() );
        transactionMasterDTO.phoneNo( entity.getPhoneNo() );
        transactionMasterDTO.itemName( entity.getItemName() );
        transactionMasterDTO.itemDesc( entity.getItemDesc() );
        transactionMasterDTO.amount( entity.getAmount() );
        transactionMasterDTO.currency( entity.getCurrency() );
        transactionMasterDTO.paymentMethod( entity.getPaymentMethod() );
        transactionMasterDTO.trnStatus( entity.getTrnStatus() );

        return transactionMasterDTO.build();
    }

    @Override
    public TransactionMaster dtoToEntity(TransactionMasterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransactionMasterBuilder transactionMaster = TransactionMaster.builder();

        transactionMaster.firstName( dto.getFirstName() );
        transactionMaster.lastName( dto.getLastName() );
        transactionMaster.emailAddress( dto.getEmailAddress() );
        transactionMaster.phoneNo( dto.getPhoneNo() );
        transactionMaster.itemName( dto.getItemName() );
        transactionMaster.itemDesc( dto.getItemDesc() );
        transactionMaster.amount( dto.getAmount() );
        transactionMaster.currency( dto.getCurrency() );
        transactionMaster.paymentMethod( dto.getPaymentMethod() );
        transactionMaster.trnStatus( dto.getTrnStatus() );
        transactionMaster.createdBy(SYSTEM);

        return transactionMaster.build();
    }

    @Override
    public List<TransactionMasterDTO> entitesToDTOs(List<TransactionMaster> entites) {
        if ( entites == null ) {
            return null;
        }

        List<TransactionMasterDTO> list = new ArrayList<TransactionMasterDTO>( entites.size() );
        for ( TransactionMaster transactionMaster : entites ) {
            list.add( entityToDTO( transactionMaster ) );
        }

        return list;
    }
}
