package com.infinity.bank.api.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infinity.bank.api.model.User;
import com.infinity.bank.api.repository.UserRepository;
@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String[] usernameData= username.split(";");
		Optional<User> user = userRepository.findByUsername(usernameData[0],usernameData[1]);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("User not found");
	}

}
