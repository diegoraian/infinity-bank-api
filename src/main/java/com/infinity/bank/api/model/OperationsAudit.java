package com.infinity.bank.api.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Value;

import com.infinity.bank.api.model.enums.OperationsEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OperationsAudit extends AbstractModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 854196153761230888L;

	@Enumerated(EnumType.STRING)
	private OperationsEnum operation;
	
	private BankData responsableAccount;
	@Value(value="0")
	private BigDecimal value;

}
