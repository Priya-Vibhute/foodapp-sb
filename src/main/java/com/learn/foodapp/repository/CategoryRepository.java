package com.learn.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.foodapp.entities.Category;

@CrossOrigin(origins = "http://localhost:5173/")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
