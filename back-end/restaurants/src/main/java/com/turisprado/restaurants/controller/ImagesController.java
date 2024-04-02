package com.turisprado.restaurants.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turisprado.restaurants.model.pojo.Image;
import com.turisprado.restaurants.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/images")
public class ImagesController {
	
	private final ImageService service;
	
	@GetMapping("idrestaurant/{restaurantId}")
	public ResponseEntity<List<Image>> getFindByName(@PathVariable Long restaurantId) {

		log.info("Request received for image {}", restaurantId);
		List<Image> image = service.getFindByrestaurantId(restaurantId);

		if (image != null) {
			return ResponseEntity.ok(image);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
