package com.bucott.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if (user == null) throw new UserNotFoundException("ID: " + id);
		
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PostMapping("/users") 
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder	// Utility class that helps us get the current request URI
				.fromCurrentRequest()				// method to get URI from current request
				.path("/{id}")						// The part that we want to modify/add to the URI
				.buildAndExpand(savedUser.getId())	// The actual value that's going into the above method's definition
				.toUri();							// convert it into uri
		
		return ResponseEntity
			.created(location)
			.build();
	}
}
