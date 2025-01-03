package com.lcwd.electronic.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lcwd.electronic.store.integration.repositories") // Update with your actual repository package
public class ElectronicStoreApplication{

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * System.out.println("Encoded password:" + passwordEncoder.encode("abcd")); }
	 */

}
