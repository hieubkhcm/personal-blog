package com.henryece.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henryece.model.Greeting;
import com.henryece.repository.GreetingRepository;

@RestController
@RequestMapping("/greeting")
public class GreetingClontroller {
	private static final Logger LOGGER = LogManager.getLogger(GreetingClontroller.class.getName());

	@Value("${greeting-name: HenryECE default @Value is in Class}") // <-- This will be the default value if 
										 // application.properties do not excusively define 
	private String name;
	private final Greeting greeting;	
	private final GreetingRepository greetingRepository;

	//no need to add autowired if there is only one contructor in the class
	//Testing combine the two ways of mapping data, traditional way and reporitory way
	@Autowired
	public GreetingClontroller(Greeting greeting, GreetingRepository greetingRepository) {
		this.greeting = greeting;
		this.greetingRepository = greetingRepository;
	}

	@Value("${greeting-coffee: ${greeting-name} is a variable in the Class}")
	private String coffee;
	
	@GetMapping
	String getGreeting() {
		return name;
	}
	
	@GetMapping("/{id}")
	Optional<Greeting> getGreeingId(@PathVariable String id){
		LOGGER.info("[HENRY-LOG] - getGreeingId called!");
		return greetingRepository.findById(id);
	}

	@PutMapping("/{id}")
	ResponseEntity<Greeting> putputCoffee(@PathVariable String id, @RequestBody Greeting greeting) {
		LOGGER.info("[HENRY-LOG] - greetingRepository called!\n");
		return (!greetingRepository.existsById(id))
				? new ResponseEntity<>(greetingRepository.save(greeting), HttpStatus.CREATED)
				: new ResponseEntity<>(greetingRepository.save(greeting), HttpStatus.OK);
		//explanation: If id is not found in the list of coffees, create new instance by calling postCoffee()
		//postOffice will return coffee, in both cases coffee will be return anyway
	}
	
	@GetMapping("/coffee")
	String getNameAndaSentence() {
		return coffee;
	}
	
	@GetMapping("/namebyproperties")
	String getGreetingByProperties() {
		return greeting.getName();
	}
	
	@GetMapping("/coffeebyproperties")
	String getNameAndaSentenceByProperties() {
		return greeting.getCoffee();
	}
	
}
