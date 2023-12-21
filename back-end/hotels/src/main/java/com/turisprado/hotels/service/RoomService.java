package com.turisprado.hotels.service;

import java.util.List;


import com.turisprado.hotels.model.pojo.Room;

public interface RoomService {
	
	List<Room> getRooms();
	
	List<Room> getFindByName(String name);
	
	List<Room> getFindByIdhotel(Long hotelId);


}
