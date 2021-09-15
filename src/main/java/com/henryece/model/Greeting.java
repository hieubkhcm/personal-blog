package com.henryece.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greeting")
@Entity //auto create a table greeting in the database postgresql if successfullu connect to the database server 
		//fully support CRUB with the database, need to implement REST if want to access the data from web client by the controller
public class Greeting {
	@Id 
	private String name;
	private String coffee;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoffee() {
		return coffee;
	}
	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}	
}




