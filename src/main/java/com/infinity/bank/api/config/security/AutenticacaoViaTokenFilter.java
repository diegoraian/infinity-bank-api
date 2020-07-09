package com.infinity.bank.api.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.infinity.bank.api.model.User;
import com.infinity.bank.api.repository.UserRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private UserRepository repository;

	public AutenticacaoViaTokenFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if (tokenService.isTokenValid(token)) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long userID = tokenService.getUserId(token);
		User user = repository.findById(userID).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
