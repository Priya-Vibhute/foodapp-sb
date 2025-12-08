package com.learn.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.entities.Cart;
import com.learn.foodapp.entities.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	Cart findByUser(User user);

}
