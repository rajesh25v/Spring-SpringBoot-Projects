package com.lcwd.electronic.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
	  @Bean public UserDetailsService userDetailsService() {
	  
	  UserDetails adminUser =
	  User.builder().username("Rajesh").roles("ADMIN").password(passwordEncoder().
	  encode("9963")).build(); UserDetails normal =
	  User.builder().username("Ramu").password(passwordEncoder().encode("kkk")).
	  roles("NORMAL").build(); return new
	  InMemoryUserDetailsManager(adminUser,normal); }
	 

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public  DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
}
