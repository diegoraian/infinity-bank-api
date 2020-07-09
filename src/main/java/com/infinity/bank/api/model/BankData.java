package com.infinity.bank.api.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity(name="USER_BANK_DATA")
@Getter
@Setter
public class BankData extends AbstractModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 61971462715115176L;

	@Column(nullable=false)
	private String agency;
	
	@Column(nullable=false)
	private String accountNumber;

	

}
