package com.turisprado.hotels.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turisprado.hotels.model.pojo.Room;

public interface RoomsRepository extends JpaRepository<Room, Long>{
	
	List<Room> findByName(String name);
	
	List<Room> findByIdhotel(Long hotelId);
}
