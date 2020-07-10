package com.infinity.bank.api.controller.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.infinity.bank.api.config.validation.validators.IsBankAccountDataValid;


public class OperationForm {

	@IsBankAccountDataValid
	private BankDataForm bankData;
	@NotNull
	private BigDecimal value;

	public BankDataForm getBankData() {
		return bankData;
	}

	public void setBankData(BankDataForm bankData) {
		this.bankData = bankData;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
