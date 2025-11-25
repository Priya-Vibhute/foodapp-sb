package com.learn.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.foodapp.entities.Product;

@RepositoryRestResource(path = "product")
@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);

	List<Product> findByPriceLessThanEqual(int price);
	
	List<Product> findByPriceBetween(int sp,int ep);
	
	List<Product> findByOrderByPriceAsc();
	
	List<Product> findByOrderByPriceDesc();
	
	

}
