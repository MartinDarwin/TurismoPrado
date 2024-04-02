package com.turisprado.boats.controller;

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

import com.turisprado.boats.model.pojo.Boat;
import com.turisprado.boats.model.request.CreateBoatRequest;
import com.turisprado.boats.service.BoatsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BoatsController {
	
	private final BoatsService service;
	
	@GetMapping("/boats")
	public ResponseEntity<List<Boat>> getHotels(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Boat> boats = service.getBoats();

		if (boats != null) {
			return ResponseEntity.ok(boats);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@PostMapping("/boat")
	public ResponseEntity<Boat> postHotel(@RequestBody CreateBoatRequest request) {

		Boat createdBoat = service.createBoat(request);

		if (createdBoat != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdBoat);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/boat/{boatId}")
	public ResponseEntity<Boat> getProduct(@PathVariable String boatId) {

		log.info("Request received for product {}", boatId);
		Boat boat = service.getBoat(boatId);

		if (boat != null) {
			return ResponseEntity.ok(boat);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
