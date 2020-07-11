package com.infinity.bank.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.bank.api.model.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Long>{

	
}
