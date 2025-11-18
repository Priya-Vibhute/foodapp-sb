package com.learn.foodapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.foodapp.dtos.UserDto;
import com.learn.foodapp.entities.User;
import com.learn.foodapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
	    User user = modelMapper.map(userDto, User.class);
	    
	    User savedUser = userRepository.save(user);
	    
	    UserDto savedDto = modelMapper.map(savedUser, UserDto.class);
	    
		return savedDto;
	}
	
	

}
