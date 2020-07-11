package com.infinity.bank.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.infinity.bank.api.model.BankData;
import com.infinity.bank.api.model.Costumer;
import com.infinity.bank.api.model.User;
import com.infinity.bank.api.repository.BankDataRepository;
import com.infinity.bank.api.repository.CostumerRepository;
import com.infinity.bank.api.repository.UserRepository;

import io.jsonwebtoken.lang.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperationsTest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BankDataRepository bankDataRepository;

	@Autowired
	CostumerRepository costumerRepository;
	public User createUserDefaultMock() {
		User user = User.builder()
				.password("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq")
				.bankData(createBankDataDefaultMock())
				.costumer(createCostumerDefaultMock()).build();
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		return userRepository.save(user);
	}

	private Costumer createCostumerDefaultMock() {
		Costumer costumer = Costumer.builder().name("DIEGO").cpf("12312312387").build();
		
		return costumerRepository.save(costumer);
	}

	public BankData createBankDataDefaultMock() {
		BankData bankData = BankData.builder()
				.agency("1235").accountNumber(new Long(System.currentTimeMillis()).toString()).balance(new BigDecimal(20)).build();
		bankData.setCreatedAt(new Date());
		bankData.setUpdatedAt(new Date());
		return bankDataRepository.save(bankData);
	}

	@Test
	public void testFindBankDataFromUserByAccountNumberAndAgency() {
		User user = createUserDefaultMock();
		Optional<BankData> bankData = bankDataRepository.findByAgencyAndAccountNumber(user.getBankData().getAgency(),
				user.getBankData().getAccountNumber());
		Assert.isTrue(bankData.isPresent());
	}
	
	@Test
	public void testDontFindBankDataFromUserByAccountNumberAndAgency() {
		User user = createUserDefaultMock();
		user.getBankData().setAccountNumber("x");
		Optional<BankData> bankData = bankDataRepository.findByAgencyAndAccountNumber(user.getBankData().getAgency(),
				user.getBankData().getAccountNumber());
		Assert.isTrue(!bankData.isPresent());
	}

}
