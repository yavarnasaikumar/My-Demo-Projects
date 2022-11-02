package com.myMiniProject.javaspringboot.miniproject.user;

import java.net.URI;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResources {

	private UserServices service;

	public UserResources(UserServices service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retriveAll() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user = service.findOne(id);
		return user;
	}
	
//	@GetMapping("/users/{bloodGroup}")
//	public User retriveUsers (@PathVariable String bloodGroup) {
//		User user = service.filterUserByBloodGroup(bloodGroup);
//		return user;
//	}
//	
//	@GetMapping("/users/{name}")
//	public User retriveUser(@PathVariable String name) {
//		User user = service.findOne(name);
//		return user;
//	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
//	@DeleteMapping("/users/{name}")
//	public void deleteUser(@PathVariable String name) {
//		service.deleteByName(name);
//	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> editUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
