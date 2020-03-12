package com.example.rest.webservice.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "spreddy",
				"$2a$10$ffhE1qT9gq1b39LnJuKi2uTHq.4.6oy8WQo.7iBRmBY6OMWLddrRm", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
				"$2a$10$ffhE1qT9gq1b39LnJuKi2uTHq.4.6oy8WQo.7iBRmBY6OMWLddrRm", "ROLE_USER_2"));
		
		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
	}
	
	/*
	 * { "token":
	 * "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcHJlZGR5IiwiZXhwIjoxNTg0MzQ3MTcwLCJpYXQiOjE1ODM3NDIzNzB9.ZLgXBdCQ5XrP2W9KSlpPb2c3pSrugQ5mFcTrsFxxEj4Ekgh9QrxpZ3VhqZjteqDd_8izfzjpEXmZCfY1Fq8g5A"
	 * }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
