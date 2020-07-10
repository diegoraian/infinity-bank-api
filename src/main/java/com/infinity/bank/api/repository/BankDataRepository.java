package com.infinity.bank.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.bank.api.model.BankData;

public interface BankDataRepository  extends JpaRepository<BankData, Long>{

	Optional<BankData> findByAgencyAndAccountNumber(String agency, String accountNumber);
}
