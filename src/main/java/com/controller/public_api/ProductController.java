package com.controller.public_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.bean.ProductBean;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/public_api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody ProductBean product){
		List<CategoryBean> categories=categoryRepository.findAll();
		
		product.setCategories(categories);
		productRepository.save(product);
		
		return ResponseEntity.ok(product);
		
	}
}
