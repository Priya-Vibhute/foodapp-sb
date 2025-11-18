package com.learn.foodapp.validators;

import com.learn.foodapp.dtos.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDto> {

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		
		return userDto.getPassword().equals(userDto.getConfirmPassword());
	}

}
