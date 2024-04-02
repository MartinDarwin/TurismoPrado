package com.turisprado.users.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.turisprado.users.model.pojo.User;
import com.turisprado.users.model.request.CreateUserRequest;
import com.turisprado.users.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {
	
	private final UsersService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<User> users = service.getUsers();

		if (users != null) {
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> postUser(@RequestBody CreateUserRequest request) {

		User createdUser = service.createUser(request);

		if (createdUser != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {

		log.info("Request received for product {}", userId);
		User user = service.getUser(userId);

		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping("/username/{name}")
	public ResponseEntity<User> findByUsername(@PathVariable String name) {

		log.info("Request received for product {}", name);
		User user = service.findByUsername(name);

		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
