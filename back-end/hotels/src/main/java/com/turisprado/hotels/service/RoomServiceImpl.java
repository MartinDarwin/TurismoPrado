package com.turisprado.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turisprado.hotels.data.RoomsRepository;
import com.turisprado.hotels.model.pojo.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomsRepository repository;
	
	@Override
	public List<Room> getRooms() {
		List<Room> rooms = repository.findAll();
		return rooms.isEmpty() ? null : rooms;
	}

	@Override
	public List<Room> getFindByName(String name) {
		List<Room> room = repository.findByName(name);
		return room.isEmpty() ? null : room;
	}

	@Override
	public List<Room> getFindByIdhotel(Long hotelId) {
		List<Room> room = repository.findByIdhotel(hotelId);
		return room.isEmpty() ? null : room;
	}
	
}
