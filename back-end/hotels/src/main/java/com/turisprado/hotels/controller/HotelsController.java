package com.turisprado.hotels.controller;

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
import com.turisprado.hotels.model.pojo.Hotel;
import com.turisprado.hotels.model.request.CreateHotelRequest;
import com.turisprado.hotels.service.HotelsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class HotelsController {
	
	private final HotelsService service;
	
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getHotels(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Hotel> hotels = service.getHotels();

		if (hotels != null) {
			return ResponseEntity.ok(hotels);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> postHotel(@RequestBody CreateHotelRequest request) {

		Hotel createdHotel = service.createHotel(request);

		if (createdHotel != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getProduct(@PathVariable String hotelId) {

		log.info("Request received for product {}", hotelId);
		Hotel hotel = service.getHotel(hotelId);

		if (hotel != null) {
			return ResponseEntity.ok(hotel);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
