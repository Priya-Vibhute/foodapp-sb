package com.learn.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.Product;
import com.learn.foodapp.entities.User;
import com.learn.foodapp.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Product> showCart(String userId) {
		User user =
				userRepository.findById(userId).orElseThrow(()->new RuntimeException("User id not found"));
		Cart cart = user.getCart();
		
		List<Product> products = cart.getProducts();
		
		return products;
	}
	
	

}
