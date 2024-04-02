package com.turisprado.restaurants.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turisprado.restaurants.model.pojo.Dish;
import com.turisprado.restaurants.service.DishService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/dishs")
public class DishsController {
	
	private final DishService service;
	
	@GetMapping
	public ResponseEntity<List<Dish>> getRooms(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Dish> dishs = service.getDishs();

		if (dishs != null) {
			return ResponseEntity.ok(dishs);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<List<Dish>> getFindByName(@PathVariable String name) {

		log.info("Request received for room {}", name);
		List<Dish> dish = service.getFindByName(name);

		if (dish != null) {
			return ResponseEntity.ok(dish);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("idrestaurant/{restaurantId}")
	public ResponseEntity<List<Dish>> getFindByName(@PathVariable Long restaurantId) {

		log.info("Request received for room {}", restaurantId);
		List<Dish> dish = service.getFindByIdrestaurant(restaurantId);

		if (dish != null) {
			return ResponseEntity.ok(dish);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
