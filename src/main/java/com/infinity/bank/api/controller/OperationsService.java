package com.infinity.bank.api.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.bank.api.BusinessException;
import com.infinity.bank.api.controller.dto.request.OperationForm;
import com.infinity.bank.api.model.BankData;
import com.infinity.bank.api.repository.BankDataRepository;

@Service
public class OperationsService {
	
	@Autowired
	private BankDataRepository bankDataRepository;
	
	public void withdraw(OperationForm operationForm){		
		BankData bankDataAccount = findBankData(operationForm);
		bankDataAccount.withdraw(operationForm.getValue());
		bankDataRepository.save(bankDataAccount);
	}
	
	public void depositFromBankAccount(OperationForm operationForm){
		BankData bankDataAccount = findBankData(operationForm);
		bankDataAccount.deposit(operationForm.getValue());
		bankDataRepository.save(bankDataAccount);
	}
	
	public BigDecimal getBalance(String agency, String accountNumber){
		return findBankData(agency,accountNumber).getBalance();
	}
	
	private BankData findBankData(OperationForm operationForm){
		return findBankData(operationForm.getBankData().getAgency(),operationForm.getBankData().getAccount());
	}
	
	private BankData findBankData(String agency, String accountNumber){
		Optional<BankData> bankData = bankDataRepository.findByAgencyAndAccountNumber(agency,accountNumber);
		if(bankData.isPresent()) {
			return bankData.get();
		}else {
			throw new BusinessException("Account not found");
		}
	}
}
