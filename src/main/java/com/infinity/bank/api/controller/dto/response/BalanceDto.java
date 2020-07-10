package com.infinity.bank.api.controller.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BalanceDto {
	
	private BigDecimal balance;

}
