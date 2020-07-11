package com.infinity.bank.api.controller.dto.response;

import com.infinity.bank.api.controller.dto.request.AuthForm;
import com.infinity.bank.api.controller.dto.request.BankDataForm;
import com.infinity.bank.api.controller.dto.request.TokenDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthDto {
	
	private BankDataForm bankData;
	
	private TokenDto token;
	
	public static AuthDto converter(AuthForm authForm, TokenDto tokenDto) {
		BankDataForm bankData = BankDataForm.builder()
				.account(authForm.getAccount())
				.agency(authForm.getAgency()).
				build();
		return new AuthDto(bankData, tokenDto);
	}

}
