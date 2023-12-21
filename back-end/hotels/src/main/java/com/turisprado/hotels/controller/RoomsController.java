package com.turisprado.hotels.controller;

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
import com.turisprado.hotels.model.pojo.Room;
import com.turisprado.hotels.service.RoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rooms")
public class RoomsController {
	
	private final RoomService service;
	
	@GetMapping
	public ResponseEntity<List<Room>> getRooms(@RequestHeader Map<String, String> headers) {

		log.info("headers: {}", headers);
		List<Room> rooms = service.getRooms();

		if (rooms != null) {
			return ResponseEntity.ok(rooms);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<List<Room>> getFindByName(@PathVariable String name) {

		log.info("Request received for room {}", name);
		List<Room> room = service.getFindByName(name);

		if (room != null) {
			return ResponseEntity.ok(room);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("idhotel/{hotelId}")
	public ResponseEntity<List<Room>> getFindByName(@PathVariable Long hotelId) {

		log.info("Request received for room {}", hotelId);
		List<Room> room = service.getFindByIdhotel(hotelId);

		if (room != null) {
			return ResponseEntity.ok(room);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
