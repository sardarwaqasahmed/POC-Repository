package com.certtin.payfast.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Table(
		name = "transaction_master"
		//uniqueConstraints = @UniqueConstraint(name = "uc_propertyTitle", columnNames = {"title"}
	  )
public class TransactionMaster {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name_first",
            nullable = false)
    @NotNull(message = "firstName can not be null!")    
    private String firstName;

    @Column(name = "name_last",
            nullable = false)
    @NotNull(message = "lastName can not be null!")
    private String lastName;

    @Column(name = "email_address",
            nullable = false)
    @NotNull(message = "email_address can not be null!")
    private String emailAddress;
    
    @Column(name = "phone_no",
            nullable = false)
    @NotNull(message = "phone_no can not be null!")
    private String phoneNo;
    
    @Column(name = "item_name",
            nullable = false)
    @NotNull(message = "item_name can not be null!")    
    private String itemName;
    
    @Column(name = "item_desc",
            nullable = false)
    @NotNull(message = "item_desc can not be null!")    
    private String itemDesc;
    
    @Column(name = "amount",
            nullable = false)
    @NotNull(message = "amount can not be null!")
    @Min(value = 0, message = "amount should be positive value.")
    private BigDecimal amount;
    
    @Column(name = "currency",
            nullable = false)
    @NotNull(message = "currency can not be null!")
    private String currency;
    
    @Column(name = "payment_method",
            nullable = false)
    @NotNull(message = "payment_method can not be null!")
    private String paymentMethod;

    private String pfPaymentId;
    
    @Column(name = "trn_status",
            nullable = false)
    @NotNull(message = "trn_status can not be null!")
    private String trnStatus;
    
    @Column(name = "created_by",
            nullable = false)
    @NotNull(message = "created_by can not be null!")
    private String createdBy;
    
    @Column(name = "created_date",
            nullable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;
    
    @Column(name = "updated_by",
            nullable = true)
    @NotNull(message = "updated_by can not be null!")
    private String updatedBy;
    
    @Column(name = "updated_date",
            nullable = true)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
