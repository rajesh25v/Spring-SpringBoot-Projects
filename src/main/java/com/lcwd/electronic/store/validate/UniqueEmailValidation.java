package com.lcwd.electronic.store.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lcwd.electronic.store.repositories.UserRepository;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (userRepository.findByEmail(value).size() == 0)
			return true;
		return false;
	}

}
