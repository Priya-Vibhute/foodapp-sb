package com.learn.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.entities.Order;

public interface OrderRepsitory extends JpaRepository<Order, Integer> {

}
