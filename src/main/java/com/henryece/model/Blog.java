package com.henryece.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "blog")
@Data //auto generate getters for all fields
@NoArgsConstructor // auto generate contructors with no argument
@AllArgsConstructor // auto generate contructors with all argument
@Entity //auto create a table greeting in the database postgresql if successfullu connect to the database server 
		//fully support CRUD with the database, need to implement REST if want to access the data from web client by the controller
public class Blog {
	@Id 
	@GeneratedValue
	private String id;
	
	private String blog;
	@SuppressWarnings("unused")
	private String comment;
	
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




