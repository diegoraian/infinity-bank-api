package com.infinity.bank.api.controller.dto.request;

import javax.validation.constraints.NotEmpty;


public class BankDataForm {

	@NotEmpty
	private String account;
	@NotEmpty
	private String agency;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
}
