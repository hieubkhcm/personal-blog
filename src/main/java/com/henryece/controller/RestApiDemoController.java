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

import com.henryece.model.Post;
import com.henryece.repository.PostRepository;

//Here is the Controller for Post
@RestController
@RequestMapping("/Posts") //<--- This is not necessary, mapping to nowhere
public class RestApiDemoController {
	private static final Logger LOGGER = LogManager.getLogger(RestApiDemoController.class.getName());
	//private static final Logger LOGGER = LogManager.getLogger(SpringBootUpAndRunningApplication.class.getName());
	//LOGGER.info("[HENRY-LOG] - This is main()\n");

	private final PostRepository PostRepository;
	@Autowired // <-- will be auto added by Soring 4.3 or above if class has only one constructor
	public RestApiDemoController(PostRepository PostRepository) {
		LOGGER.info("[HENRY-LOG] - RestApiDemoController Constructor called!\n");
		this.PostRepository = PostRepository;
	}

	//@RequestMapping(value = "/myPosts", method = RequestMethod.GET) <-- these two annotations are equivalent
	@GetMapping // <=> @GetMapping("") but not equal to @GetMapping("\") 
	Iterable<Post> getPosts(){
		LOGGER.info("[HENRY-LOG] - getPosts called!\n");
		return PostRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Post> getPostById(@PathVariable String id){
		LOGGER.info("[HENRY-LOG] - getPostById called!\n");
		return PostRepository.findById(id);
	}

	@PostMapping("") // <=> @PostMapping("") but not equal to @PostMapping("\") 
	Post postPost(@RequestBody Post Post) {
		LOGGER.info("[HENRY-LOG] - postPost called!\n");
		return PostRepository.save(Post);
	}

	@PutMapping("/{id}")
	ResponseEntity<Post> putPost(@PathVariable String id, @RequestBody Post Post) {
		LOGGER.info("[HENRY-LOG] - putPost called!\n");
		return (!PostRepository.existsById(id))
				? new ResponseEntity<>(PostRepository.save(Post), HttpStatus.CREATED)
				: new ResponseEntity<>(PostRepository.save(Post), HttpStatus.OK);
		//explanation: If id is not found in the list of Posts, create new instance by calling postPost()
		//postOffice will return Post, in both cases Post will be return anyway
	}

	@DeleteMapping("/{id}")
	void deletePost(@PathVariable String id){
		LOGGER.info("[HENRY-LOG] - deletePost called!\n");
		//boolean val = c->c.getId().equals(id);
		PostRepository.deleteById(id);
		}
}















