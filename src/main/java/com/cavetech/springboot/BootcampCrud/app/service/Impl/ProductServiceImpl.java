package com.cavetech.springboot.BootcampCrud.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavetech.springboot.BootcampCrud.app.domain.Product;
import com.cavetech.springboot.BootcampCrud.app.repository.ProductRepository;
import com.cavetech.springboot.BootcampCrud.app.service.ProductService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

	
	   @Autowired
	    private ProductRepository productRepository;

	@Override
	public Mono<Product> save(Product message) {
		return this.productRepository.save(message);
	}

	@Override
	public Mono<Product> delete(String id) {
	     return this.productRepository
	                .findById(id)
	                .flatMap(p -> this.productRepository.deleteById(p.getId()).thenReturn(p));

	}

	@Override
	public Mono<Product> update(String id, Product message) {
        return this.productRepository.findById(id)
                .flatMap(message1 -> {
                    message.setId(id);
                    return save(message);
                })
                .switchIfEmpty(Mono.empty());
	}

	@Override
	public Flux<Product> findAll() {
		  return this.productRepository.findAll();
	}

	@Override
	public Mono<Product> findById(String id) {
		  return this.productRepository.findById(id);
	}

}
