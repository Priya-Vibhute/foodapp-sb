package com.learn.foodapp.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.learn.foodapp.dtos.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private String token;
	private UserDto userDto;
	
	


}
