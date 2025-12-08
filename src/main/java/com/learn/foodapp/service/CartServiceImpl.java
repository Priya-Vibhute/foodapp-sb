package com.learn.foodapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.Product;
import com.learn.foodapp.entities.User;
import com.learn.foodapp.repository.CartRepository;
import com.learn.foodapp.repository.ProductRepository;
import com.learn.foodapp.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Product> showCart(String userId) {
		User user =
				userRepository.findById(userId).orElseThrow(()->new RuntimeException("User id not found"));
		Cart cart = cartRepository.findByUser(user);
		
		List<Product> products = cart.getProducts();
		
		return products;
	}

	@Override
	public void addToCart(String userId, int productId) {
		
		User user = userRepository.findById(userId)
		.orElseThrow(()->new RuntimeException("User not found"));
		
		Product product = productRepository.findById(productId)
		.orElseThrow(()->new RuntimeException("Product no found"));
		
		Cart cart = cartRepository.findByUser(user);
		
		
		
	
		
		cart.getProducts().add(product);
		
		cartRepository.save(cart);
	
		
	}
	
	

}
