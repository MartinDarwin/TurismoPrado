package com.turisprado.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.hotels.data.HotelsRepository;
import com.turisprado.hotels.model.pojo.Hotel;
import com.turisprado.hotels.model.request.CreateHotelRequest;



@Service
public class HotelsServiceImpl implements HotelsService {

	@Autowired
	private HotelsRepository repository;
	
	@Override
	public List<Hotel> getHotels() {
		List<Hotel> hotels = repository.findAll();
		return hotels.isEmpty() ? null : hotels;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return repository.findById(Long.valueOf(hotelId)).orElse(null);
	}

	@Override
	public Boolean removHotel(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel createHotel(CreateHotelRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getDescription().trim())
				&& StringUtils.hasLength(request.getImage().trim())
				&& request.getPrice() != null
				&& StringUtils.hasLength(request.getCategory().trim()) 
				&& StringUtils.hasLength(request.getInventoryStatus().trim())							
				&& request.getRating() != null){

			Hotel hotel = Hotel.builder()
					.name(request.getName())
					.description(request.getDescription())
					.image(request.getImage())
					.price(request.getPrice())
					.category(request.getCategory())
					.inventoryStatus(request.getInventoryStatus())
					.rating(request.getRating()).build();

			return repository.save(hotel);
		} else {
			return null;
		}
	}

}
