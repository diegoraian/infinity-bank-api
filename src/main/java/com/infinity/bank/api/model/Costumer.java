package com.infinity.bank.api.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="costumers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Costumer extends AbstractModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3316968569699810795L;
	@Column( nullable=false)
	private String name;

	@Column( nullable=false)
	private String cpf;




}
