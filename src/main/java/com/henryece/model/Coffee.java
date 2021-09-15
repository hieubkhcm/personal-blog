package com.henryece.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//this class is the object that is stored ID/name for a type of coffee
//https://en.wikipedia.org/wiki/Jakarta_Persistence <-- 1 entity is considered as 1 "row" in database
@Entity // <-- This annotation belong to JPA persitence <-- relate to database and JPA compliant
//@Table(name = "CoffeesTable")
public class Coffee {
	@Id // <-- This annotation belong to JPA persitence <-- relate to database and JPA compliant
	private String id ;
	private String name; 
	private String remark_dummy;
	
	public String getRemark() {
		return remark_dummy;
	}

	public void setRemark(String remark) {
		this.remark_dummy = remark;
	}

	private static final Logger LOGGER = LogManager.getLogger(Coffee.class.getName());
	//LOGGER.info("[HENRY-LOG] - This is main()\n");

	public Coffee(String id, String name) {
		this.id = id;
		this.name = name;
		LOGGER.info("[HENRY-LOG] - Coffee(id,name) constructor called!\n");
	}

	public Coffee() {
	}

	public Coffee(String name) {
		this(UUID.randomUUID().toString(),name);
		LOGGER.info("[HENRY-LOG] - Coffee(name) constructor called!\n");
	}

	public String getName() {
		LOGGER.info("[HENRY-LOG] - getName() called!\n");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("[HENRY-LOG] - setName() called!\n");
		this.name = name;
	}

	public String getId() {
		LOGGER.info("[HENRY-LOG] - getId() called!\n");
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}