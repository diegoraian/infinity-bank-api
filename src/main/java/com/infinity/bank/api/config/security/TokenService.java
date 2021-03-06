package com.infinity.bank.api.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.infinity.bank.api.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class TokenService {
	@Value("${api.jwt.expiration}")
	private String expiration;
	
	@Value("${api.jwt.secret}")
	private String secret;
	
	private String DEFAULT_ISSUER = "INFINITY-BANK-API";

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String generateToken(Authentication authentication) {
		User userLogged = (User) authentication.getPrincipal();
		Date currentDate = new Date();
		Date tokenExpirationTime = new Date(currentDate.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer(DEFAULT_ISSUER)
				.setIssuedAt(currentDate)
				.setExpiration(tokenExpirationTime)
				.setSubject(userLogged.getId().toString()) //TODO Need convert to json some userData
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public Long getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}


}
