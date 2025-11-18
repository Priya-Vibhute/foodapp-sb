package com.learn.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
