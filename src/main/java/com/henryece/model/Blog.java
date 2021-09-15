package com.henryece.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "blog")
@Entity //auto create a table greeting in the database postgresql if successfullu connect to the database server 
		//fully support CRUD with the database, need to implement REST if want to access the data from web client by the controller
public class Blog {
	@Id 
	private String id;
	private String blog;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}	
}




