package com.infinity.bank.api.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
	private String token;
	private String tipo;
	
	
	public TokenDto(String token, String tipo) {
		super();
		this.token = token;
		this.tipo = tipo;
	}

	
	
}
