package com.lcwd.electronic.store.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lcwd.electronic.store.entities.User;
import com.lcwd.electronic.store.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> listUsers = userRepository.findByEmail(username);

		if (StringUtils.isEmpty(listUsers)) {
			throw new UsernameNotFoundException("User with given email not Found!!");
		} else {
			return listUsers.stream().findFirst().get();
		}
	}
}
