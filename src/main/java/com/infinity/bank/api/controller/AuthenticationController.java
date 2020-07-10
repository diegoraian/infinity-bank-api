package com.infinity.bank.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.bank.api.config.security.TokenService;
import com.infinity.bank.api.controller.dto.request.AuthForm;
import com.infinity.bank.api.controller.dto.request.TokenDto;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity <TokenDto>autenticar(@RequestBody @Valid AuthForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		Authentication authentication = authManager.authenticate(dadosLogin);
		return ResponseEntity.ok(new TokenDto(tokenService.generateToken(authentication), "Bearer"));
	}

}
