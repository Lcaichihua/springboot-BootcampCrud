package com.cavetech.springboot.BootcampCrud.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.BootcampCrud.app.domain.Product;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

	
		
}
