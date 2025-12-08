package com.learn.foodapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.foodapp.entities.Product;
import com.learn.foodapp.service.CartService;

@RestController
@RequestMapping("/cart")

public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{userId}/products")
	public ResponseEntity<List<Product>> showCart(@PathVariable String userId)
	{
		List<Product> products = cartService.showCart(userId);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	
	@PostMapping("/{userId}/add-to-cart/{productId}")
	public ResponseEntity<String> addToCart(@PathVariable String userId,@PathVariable int productId)
	{
		cartService.addToCart(userId, productId);
		return ResponseEntity.ok("Product added into the cart");
	}

}
