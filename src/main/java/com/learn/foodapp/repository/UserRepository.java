package com.learn.foodapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.foodapp.entities.User;

public interface UserRepository extends JpaRepository<User,String> {
	
   Optional<User> findByEmail(String email);
   boolean existsByEmail(String email);

}
