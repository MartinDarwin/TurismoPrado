package com.turisprado.hotels.service;

import java.util.List;

import com.turisprado.hotels.model.pojo.Hotel;
import com.turisprado.hotels.model.request.CreateHotelRequest;

public interface HotelsService {

	List<Hotel> getHotels();
	
	Hotel getHotel(String hotelId);
	
	Boolean removHotel(String hotelId);
	
	Hotel createHotel(CreateHotelRequest request);
}
