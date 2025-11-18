package com.learn.foodapp.service;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learn.foodapp.FoodappApplication;
import com.learn.foodapp.dtos.ProductDto;
import com.learn.foodapp.entities.Category;
import com.learn.foodapp.entities.Product;
import com.learn.foodapp.repository.CategoryRepository;
import com.learn.foodapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final FoodappApplication foodappApplication;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;


    ProductServiceImpl(FoodappApplication foodappApplication) {
        this.foodappApplication = foodappApplication;
    }
	

	@Override
	public ProductDto addProduct(ProductDto productDto) {
	   Product product = modelMapper.map(productDto, Product.class);
	   System.out.println(product);
	   Product savedProduct = productRepository.save(product);
	   ProductDto savedDto = modelMapper.map(savedProduct,ProductDto.class);
	   return savedDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productDtoList = products
		.stream()
		.map(p->modelMapper.map(p, ProductDto.class))
		.toList();

		return productDtoList;
	}

	@Override
	public ProductDto getProductById(int id) {
		
		Product product = productRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		
		return productDto;
	}

	@Override
	public ProductDto updateProduct(int id, ProductDto productDto) {
		
		Product product = productRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		Product updatedProduct = productRepository.save(product);
		
		ProductDto dto = modelMapper.map(updatedProduct, ProductDto.class);
		
		return dto;
	}

	@Override
	public void deleteById(int id) {
		
		Product product = productRepository.findById(id)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		productRepository.delete(product);
	}

//	 (2,4)
	@Override
	public ProductDto assignCategory(int productId, int categoryId) {
		
		Product product = productRepository.findById(productId)
				.orElseThrow(()->new RuntimeException("Id not found"));
		
		Category category = categoryRepository.findById(categoryId)
		.orElseThrow(()->new RuntimeException("Id not found"));
		
		product.setCategory(category);
		
		Product savedProduct = productRepository.save(product);	
		
		ProductDto productDto = modelMapper.map(savedProduct, 
				                     ProductDto.class);
		
		return productDto;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
