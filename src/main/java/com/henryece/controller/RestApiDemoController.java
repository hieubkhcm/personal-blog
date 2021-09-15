//Henry's comments:
//	- A complete Restful support class need to implement the four most basic methos that are Get Post Put Delete
//	- So that client and manipulate with the instances

package com.henryece.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henryece.model.Coffee;
import com.henryece.repository.CoffeeRepository;

//Here is the Controller for coffee
@RestController
@RequestMapping("/coffees") //<--- This is not necessary, mapping to nowhere
public class RestApiDemoController {
	private static final Logger LOGGER = LogManager.getLogger(RestApiDemoController.class.getName());
	//private static final Logger LOGGER = LogManager.getLogger(SpringBootUpAndRunningApplication.class.getName());
	//LOGGER.info("[HENRY-LOG] - This is main()\n");

	private final CoffeeRepository coffeeRepository;
	@Autowired // <-- will be auto added by Soring 4.3 or above if class has only one constructor
	public RestApiDemoController(CoffeeRepository coffeeRepository) {
		LOGGER.info("[HENRY-LOG] - RestApiDemoController Constructor called!\n");
		this.coffeeRepository = coffeeRepository;
	}

	//@RequestMapping(value = "/mycoffees", method = RequestMethod.GET) <-- these two annotations are equivalent
	@GetMapping // <=> @GetMapping("") but not equal to @GetMapping("\") 
	Iterable<Coffee> getCoffees(){
		LOGGER.info("[HENRY-LOG] - getCoffees called!\n");
		return coffeeRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id){
		LOGGER.info("[HENRY-LOG] - getCoffeeById called!\n");
		return coffeeRepository.findById(id);
	}

	@PostMapping("") // <=> @PostMapping("") but not equal to @PostMapping("\") 
	Coffee postCoffee(@RequestBody Coffee coffee) {
		LOGGER.info("[HENRY-LOG] - postCoffee called!\n");
		return coffeeRepository.save(coffee);
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		LOGGER.info("[HENRY-LOG] - putCoffee called!\n");
		return (!coffeeRepository.existsById(id))
				? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED)
				: new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
		//explanation: If id is not found in the list of coffees, create new instance by calling postCoffee()
		//postOffice will return coffee, in both cases coffee will be return anyway
	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id){
		LOGGER.info("[HENRY-LOG] - deleteCoffee called!\n");
		//boolean val = c->c.getId().equals(id);
		coffeeRepository.deleteById(id);
		}
}















