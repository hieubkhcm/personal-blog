package com.henryece.model;

import java.util.UUID;

//@Entity
public class Droid {
//	@Id
	private String id, description;

	public Droid(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public Droid() {
	}
	
	public Droid(String name) {
		this(UUID.randomUUID().toString(),name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}



