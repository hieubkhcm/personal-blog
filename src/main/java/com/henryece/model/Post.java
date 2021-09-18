package com.henryece.model;

import java.util.UUID;

import javax.persistence.Entity; //JPA = Java Persistence API ~ hibernate --> JPA
import javax.persistence.Id;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//this class is the object that is stored ID/name for a type of Post
//https://en.wikipedia.org/wiki/Jakarta_Persistence <-- 1 entity is considered as 1 "row" in database
@Entity // <-- This annotation belong to JPA persitence <-- relate to database and JPA compliant
//@Table(name = "PostsTable")
public class Post {
	@Id // <-- This annotation belong to JPA persitence <-- relate to database and JPA compliant
	private String id ;
	private String name; 

	private static final Logger LOGGER = LogManager.getLogger(Post.class.getName());
	//LOGGER.info("[HENRY-LOG] - This is main()\n");

	public Post(String id, String name) {
		this.id = id;
		this.name = name;
		LOGGER.info("[HENRY-LOG] - Post(id,name) constructor called!\n");
	}

	public Post() {
	}

	public Post(String name) {
		this(UUID.randomUUID().toString(),name);
		LOGGER.info("[HENRY-LOG] - Post(name) constructor called!\n");
	}

	public String getId() {
		LOGGER.info("[HENRY-LOG] - getId() called!\n");
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		LOGGER.info("[HENRY-LOG] - getName() called!\n");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("[HENRY-LOG] - setName() called!\n");
		this.name = name;
	}

}