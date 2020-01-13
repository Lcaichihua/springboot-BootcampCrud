package com.cavetech.springboot.BootcampCrud.app.service;

import com.cavetech.springboot.BootcampCrud.app.domain.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	Mono<Product> save(Product message);
	 
    Mono<Product> delete(String id);

    Mono<Product> update(String id, Product message);

  //  Flux<Product> findByThreadId(String threadId);

    Flux<Product> findAll();

    Mono<Product> findById(String id);
}
