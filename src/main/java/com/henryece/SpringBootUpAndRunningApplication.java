package com.henryece;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import com.henryece.model.Droid;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootUpAndRunningApplication {
	private static final Logger LOGGER = LogManager.getLogger(SpringBootUpAndRunningApplication.class.getName());
	//private static final Logger LOGGER = LogManager.getLogger(SpringBootUpAndRunningApplication.class.getName());
	//LOGGER.info("[HENRY-LOG] - This is main()\n");

	public static void main(String[] args) {
		LOGGER.info("[HENRY-LOG] - main() START!\n");
		SpringApplication.run(SpringBootUpAndRunningApplication.class, args);
		LOGGER.info("[HENRY-LOG] - main() END!\n");
	}
	
	
	@Bean //This methos is not nescessarily put here but elsewhere with Class mark by @Configuration
	@ConfigurationProperties(prefix = "droid") //noted: @SpringBootApplication includes @Configuration in it
	Droid createDroid() {
		LOGGER.info("[HENRY-LOG] - createDroid() START!\n");
		return new Droid();
	}


}

//moved model to a seperated package to easy import/export
