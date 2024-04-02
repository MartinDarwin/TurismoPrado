package com.turisprado.restaurants.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.turisprado.restaurants.model.pojo.Reserve;
import com.turisprado.restaurants.model.request.CreateReserveRequest;
import com.turisprado.restaurants.service.ReserveService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ReservesController {
	
	private final ReserveService service;
	
	@PostMapping("/reserve")
	public ResponseEntity<Reserve> postReserve(@RequestBody CreateReserveRequest request) {

		Reserve createdReserve = service.createReserve(request);

		if (createdReserve != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdReserve);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/reserves")
	public ResponseEntity<List<Reserve>> getReserves(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Reserve> reserves = service.getReserves();

		if (reserves != null) {
			return ResponseEntity.ok(reserves);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@GetMapping("/reserves_restaurant")
	public ResponseEntity<List<Reserve>> getReservesRestaurant(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Reserve> reserves = service.getReservesRestaurant();

		if (reserves != null) {
			return ResponseEntity.ok(reserves);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

}
