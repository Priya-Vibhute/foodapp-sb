package com.learn.foodapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.foodapp.dtos.UserDto;
import com.learn.foodapp.repository.UserRepository;
import com.learn.foodapp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
//	==================================================================
//	POST-/users/register
//	==================================================================
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto)
	{
		UserDto savedDto = userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(savedDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/{email}/check")
	public boolean checkEmail(@PathVariable String email)
	{
		return userRepository.existsByEmail(email);
	}

}
