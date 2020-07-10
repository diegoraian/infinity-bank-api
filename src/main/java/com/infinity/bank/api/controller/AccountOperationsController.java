package com.infinity.bank.api.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.bank.api.controller.dto.request.OperationForm;
import com.infinity.bank.api.controller.dto.response.BalanceDto;
@RestController
@RequestMapping(value="/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountOperationsController {
	@Autowired
	private OperationsService operationsService;
	
	
	@GetMapping("/{agency}/{accountNumber}")
	public ResponseEntity<BalanceDto> balance(@PathVariable String agency, @PathVariable String accountNumber) {
		BigDecimal balance = operationsService.getBalance(agency,accountNumber);
		return ResponseEntity.ok().body(new BalanceDto(balance));
	}
	
	
	@PatchMapping("/withdraw")
	public ResponseEntity<Object> withdraw(@RequestBody @Valid OperationForm value) {
		operationsService.withdraw(value);
		return ResponseEntity.ok().build();
		
	}
	

	@PatchMapping("/deposit")
	public ResponseEntity<Object> deposit(@RequestBody @Valid OperationForm value)  {
		operationsService.depositFromBankAccount(value);
		return ResponseEntity.ok().build();
	}

}
