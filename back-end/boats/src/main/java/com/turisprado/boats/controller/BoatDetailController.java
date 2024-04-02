package com.turisprado.boats.controller;

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

import com.turisprado.boats.model.pojo.BoatDetail;
import com.turisprado.boats.service.BoatDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/boat_detail")
public class BoatDetailController {
	
	private final BoatDetailService service;
	
	@GetMapping
	public ResponseEntity<List<BoatDetail>> getBoatDetail(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<BoatDetail> boatdetails = service.getBoatdetails();

		if (boatdetails != null) {
			return ResponseEntity.ok(boatdetails);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<List<BoatDetail>> getFindByName(@PathVariable String name) {

		log.info("Request received for room {}", name);
		List<BoatDetail> boatdetail = service.getFindByName(name);

		if (boatdetail != null) {
			return ResponseEntity.ok(boatdetail);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("idboat/{boatId}")
	public ResponseEntity<List<BoatDetail>> getFindByBoat(@PathVariable Long boatId) {

		log.info("Request received for room {}", boatId);
		List<BoatDetail> boatdetail = service.getFindByIdboat(boatId);

		if (boatdetail != null) {
			return ResponseEntity.ok(boatdetail);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
