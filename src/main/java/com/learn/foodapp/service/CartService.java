package com.learn.foodapp.service;

import java.util.List;
import java.util.Optional;

import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.Product;

public interface CartService {
	
	List<Product> showCart(String userId);
	
	void addToCart(String userId,int productId);

}
