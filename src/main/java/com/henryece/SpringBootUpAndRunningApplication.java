package com.henryece;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

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
	
}
