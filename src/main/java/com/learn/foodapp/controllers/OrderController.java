package com.learn.foodapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.Order;
import com.learn.foodapp.entities.OrderItem;
import com.learn.foodapp.entities.Product;
import com.learn.foodapp.entities.User;
import com.learn.foodapp.repository.CartRepository;
import com.learn.foodapp.repository.OrderItemRepository;
import com.learn.foodapp.repository.OrderRepsitory;
import com.learn.foodapp.repository.UserRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepsitory orderRepsitory;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@PostMapping("/place/{userId}")
	public ResponseEntity<Order> placeOrder(@PathVariable String userId ,
			@AuthenticationPrincipal UserDetails userDetails)
	{
		User user = userRepository.findByEmail(userDetails.getUsername())
		.orElseThrow(()->new RuntimeException("User not found"));
		
		if(!user.getId().equals(userId))
		{
			return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
		}
		
		
		Cart cart = user.getCart();
		List<Product> products = cart.getProducts();
		
		Integer totalAmount = products.stream().map(p->p.getPrice()).reduce((a,b)->a+b).get();
		Order order = new Order();
		order.setAmount(totalAmount);
		order.setUser(user);
		
		Order savedOrder = orderRepsitory.save(order);
		
		products.stream().forEach((p)->{
			OrderItem   orderItem =new OrderItem();
			orderItem.setProduct(p);
			orderItem.setOrder(savedOrder);
			OrderItem savedOrderItem = orderItemRepository.save(orderItem);	
		});
		
		cart.getProducts().clear();
		Cart savedCart= cartRepository.save(cart);
		
		return new ResponseEntity<Order>(savedOrder,HttpStatus.OK);
	}
	
	
	

}
