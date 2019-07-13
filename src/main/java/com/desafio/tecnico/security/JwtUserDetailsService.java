package com.desafio.tecnico.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		if ("desafiotecnico".equals(usuario)) {
			return new User("desafiotecnico", "$2a$10$eVuFicddrXRhwCLWFBPLpu0cni6SlO5jf3.vLcF6TXRUUmifoZTYe", new ArrayList<>());
		}
		return null;
	}

	
	
}
