package com.turisprado.hotels.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turisprado.hotels.model.pojo.Image;
import com.turisprado.hotels.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/images")
public class ImagesController {
	
	private final ImageService service;
	
	@GetMapping("idhotel/{hotelId}")
	public ResponseEntity<List<Image>> getFindByName(@PathVariable Long hotelId) {

		log.info("Request received for image {}", hotelId);
		List<Image> image = service.getFindByIdhotel(hotelId);

		if (image != null) {
			return ResponseEntity.ok(image);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
