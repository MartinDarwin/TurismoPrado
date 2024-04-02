package com.turisprado.restaurants.controller;

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

import com.turisprado.restaurants.model.pojo.Restaurant;
import com.turisprado.restaurants.model.request.CreateRestaurantRequest;
import com.turisprado.restaurants.service.RestaurantsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantsController {
	
	private final RestaurantsService service;
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getRestaurants(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Restaurant> restaurants = service.getRestaurants();

		if (restaurants != null) {
			return ResponseEntity.ok(restaurants);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> postRestaurant(@RequestBody CreateRestaurantRequest request) {

		Restaurant createdRestaurant = service.createRestaurant(request);

		if (createdRestaurant != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable String restaurantId) {

		log.info("Request received for product {}", restaurantId);
		Restaurant restaurant = service.getRestaurant(restaurantId);

		if (restaurant != null) {
			return ResponseEntity.ok(restaurant);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
