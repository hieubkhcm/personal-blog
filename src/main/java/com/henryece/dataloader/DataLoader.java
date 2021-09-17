package com.henryece.dataloader;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Component;

import com.henryece.model.Post;
import com.henryece.repository.PostRepository;

//@Component //this annotation helps to separate creating dummy records from RestApiDemoController, so it can be pure API
//remove the comment out mark will create the table in the database at run time. , You can choose to use .sql. Its better to have options
public class DataLoader {
	private static final Logger LOGGER = LogManager.getLogger(DataLoader.class.getName());

	private final PostRepository postRepository;

	public DataLoader(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@PostConstruct //This loadData() helps to create dummy datas for testing the functions
	private void loadData() {
		LOGGER.info("[HENRY-LOG] - RestApiDemoController Constructor called!\n");
		postRepository.saveAll(List.of(
				new Post("1","Bai thu nhat"),
				new Post("2","Bai thu hai"),
				new Post("3","Bai thu ba"),
				new Post("4","Bai thu bon")));
	}	
}
