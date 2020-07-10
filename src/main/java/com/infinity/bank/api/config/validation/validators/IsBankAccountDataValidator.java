package com.infinity.bank.api.config.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.infinity.bank.api.controller.dto.request.AuthForm;
import com.infinity.bank.api.controller.dto.request.BankDataForm;
import com.infinity.bank.api.model.BankData;
import com.infinity.bank.api.util.DataUtil;

public class IsBankAccountDataValidator implements ConstraintValidator<IsBankAccountDataValid, BankDataForm> {

	@Override
	public boolean isValid(BankDataForm bankData, ConstraintValidatorContext arg1) {
		return (!DataUtil.isNull(bankData) && !DataUtil.isNull(bankData.getAgency()) && !DataUtil.isNull(bankData.getAccount())) ? true : false;
	}

}
