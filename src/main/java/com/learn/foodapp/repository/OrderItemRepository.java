package com.learn.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
