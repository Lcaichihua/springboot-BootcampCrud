package com.cavetech.springboot.BootcampCrud.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.cavetech.springboot.BootcampCrud.app.domain.Product;
import com.cavetech.springboot.BootcampCrud.app.repository.ProductRepository;

import reactor.core.publisher.Flux;
@EnableReactiveMongoRepositories
@SpringBootApplication
public class SpringbootBootcampCrudApplication  implements CommandLineRunner {
	@Autowired
	private ProductRepository clienteRepo;
	@Autowired
	private ReactiveMongoTemplate template;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBootcampCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(Product.class).subscribe();
		Product prod1 = new Product(); 
		Product prod2 = new Product(); 
		prod1.setName("Cuentas bancarias");
		prod1.setDescription(" para ahorro ,cuentas corrientes ,cuentas a plazo fijo");
		prod1.setState(true);
	
		prod2.setName("Creditos");
		prod2.setDescription(" para personal ,empresarial , tarjetas de credito y adelanto de efectivo");
		prod2.setState(true);
		
	
		Flux.just(prod1).flatMap(fun -> clienteRepo.save(fun) ).subscribe();
		Flux.just(prod2).flatMap(fun -> clienteRepo.save(fun) ).subscribe();
		
	}

}
