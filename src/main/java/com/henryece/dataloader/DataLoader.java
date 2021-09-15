package com.henryece.dataloader;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.henryece.model.Coffee;
import com.henryece.repository.CoffeeRepository;


@Component //this annotation helps to separate creating dummy records from RestApiDemoController, so it can be pure API
public class DataLoader {
	private static final Logger LOGGER = LogManager.getLogger(DataLoader.class.getName());

	private final CoffeeRepository coffeeRepository;

	public DataLoader(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@PostConstruct //This loadData() helps to create dummy datas for testing the functions
	private void loadData() {
		LOGGER.info("[HENRY-LOG] - RestApiDemoController Constructor called!\n");
		coffeeRepository.saveAll(List.of(
				new Coffee("1","Cafe Gội Đầu"),
				new Coffee("2","Cafe Milano"),
				new Coffee("3","Cafe Trung Nguyen"),
				new Coffee("4","Cafe Vinacafe")));
	}
	
	
}
