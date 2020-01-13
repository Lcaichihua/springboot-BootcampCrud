package com.cavetech.springboot.BootcampCrud.app.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "product")
public class Product {
	
	@Id
	private String id;
	
	private String name ;
	private String description ;
	private boolean state ;
	public Product() {
		
		
	}
	public Product(String id, String name, String description, boolean state) {
	
		this.id = id;
		this.name = name;
		this.description = description;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	
	
	

}
