package com.learn.foodapp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.foodapp.controllers.Role;
import com.learn.foodapp.dtos.UserDto;
import com.learn.foodapp.entities.AppRole;
import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.User;
import com.learn.foodapp.repository.CartRepository;
import com.learn.foodapp.repository.RoleRepository;
import com.learn.foodapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
	    User user = modelMapper.map(userDto, User.class);
	    
	    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
	    
	    Role role = roleRepository.findByRoleName(AppRole.ROLE_USER)
	    .orElseThrow(()->new RuntimeException("Role Not found"));
	    
	    user.setRole(role);
	    
	    
	    User savedUser = userRepository.save(user);
	    
	    
	    Cart cart = new Cart();
	    cart.setUser(savedUser);
	    cartRepository.save(cart);
	    
	    
	    UserDto savedDto = modelMapper.map(savedUser, UserDto.class);
	    
		return savedDto;
	}
	
	

}
