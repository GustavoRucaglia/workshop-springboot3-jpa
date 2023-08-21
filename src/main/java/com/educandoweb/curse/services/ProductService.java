package com.educandoweb.curse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curse.entities.Product;
import com.educandoweb.curse.repositories.ProductRepository;

@Service
public class ProductService {
	
		@Autowired
		private ProductRepository repository;
		
		public List<Product> findAll(){
			return repository.findAll();
		}
		
		public Product findById(Long id) {
			Optional<Product> obj = repository.findById(id);
			return obj.get();
		}
}
