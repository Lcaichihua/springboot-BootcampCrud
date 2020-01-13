


package com.cavetech.springboot.BootcampCrud.app.controllers;

import com.cavetech.springboot.BootcampCrud.app.domain.Product;
import com.cavetech.springboot.BootcampCrud.app.service.ProductService;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Product> save(@RequestBody @Valid Product product) {
        return this.productService.save(product);
    }

    @DeleteMapping("/list/{id}")
    private Mono<ResponseEntity<Product>> delete(@PathVariable("id") String id) {
        return this.productService.delete(id)
                .flatMap(product -> Mono.just(ResponseEntity.ok(product)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/list/{id}")
    private Mono<ResponseEntity<Product>> update(@PathVariable("id") String id, @RequestBody Product product) {
        return this.productService.update(id, product)
                .flatMap(product1 -> Mono.just(ResponseEntity.ok(product1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

  
    @GetMapping(value = "/list")
    private Flux<Product> findAll() {
        return this.productService.findAll();
        
       
    }
    
    @GetMapping(value ="/list/{id}")
    private Mono<Product> findProduct(@PathVariable("id") String id) {
    	
  return this.productService.findById(id);  	
    }
    

}
