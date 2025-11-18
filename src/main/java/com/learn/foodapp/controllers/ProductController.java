package com.learn.foodapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.learn.foodapp.dtos.ProductDto;
import com.learn.foodapp.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	==================================================================	
//	POST-products                    localhost:8080/products
//	===================================================================
	
	@PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto)
    {
		ProductDto product = productService.addProduct(productDto);
		
    	return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
    }
	
	
//	==================================================================	
//	GET-products                    localhost:8080/products
//	===================================================================
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts()
	{
		List<ProductDto> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(allProducts,HttpStatus.OK);
	}
	
	
	
//	==================================================================	
//	GET-products/{id}                   localhost:8080/products/9
//	===================================================================
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int id)
	{
		ProductDto productDto = productService.getProductById(id);
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.FOUND);
	}
	
	
	
	
//	==================================================================	
//	PUT-products/{id}                   localhost:8080/products/9
//	===================================================================
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,
			                                      @RequestBody ProductDto productDto)
	                                                       
	{
		ProductDto updatedProduct = productService.updateProduct(id, productDto);
		return new ResponseEntity<ProductDto>(updatedProduct, HttpStatus.OK);
	}
	
	
	
//	==================================================================	
//	DELETE-products/{id}                   localhost:8080/products/9
//	===================================================================
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		productService.deleteById(id);
		return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
	}
	
	
//	==================================================================	
//	PUT-products/{id}/category/{cid}           localhost:8080/products/2/category/3
//	===================================================================
	@PutMapping("/{pid}/category/{cid}")
	public ResponseEntity<ProductDto> assignCategory(@PathVariable int pid,
			                                                 @PathVariable int cid)
	{
		ProductDto productDto = productService.assignCategory(pid, cid);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
	}
	
	
	
	
	

	
}
