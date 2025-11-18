package com.learn.foodapp.service;

import java.util.List;

import com.learn.foodapp.dtos.ProductDto;

public interface ProductService {
	
	ProductDto addProduct(ProductDto productDto);
	
	List<ProductDto> getAllProducts();
	
	ProductDto getProductById(int id);
	
	ProductDto updateProduct(int id, ProductDto productDto);
	
	void deleteById(int id);
	
	ProductDto assignCategory
	(int productId,int categoryId);
	
	

}
