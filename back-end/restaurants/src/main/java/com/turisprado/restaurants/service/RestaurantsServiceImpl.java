package com.turisprado.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.restaurants.data.RestaurantsRepository;
import com.turisprado.restaurants.model.pojo.Restaurant;
import com.turisprado.restaurants.model.request.CreateRestaurantRequest;



@Service
public class RestaurantsServiceImpl implements RestaurantsService {

	@Autowired
	private RestaurantsRepository repository;
	
	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> hotels = repository.findAll();
		return hotels.isEmpty() ? null : hotels;
	}

	@Override
	public Restaurant getRestaurant(String hotelId) {
		return repository.findById(Long.valueOf(hotelId)).orElse(null);
	}

	@Override
	public Boolean removeRestaurant(String hotelId) {
		return null;
	}

	@Override
	public Restaurant createRestaurant(CreateRestaurantRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getDescription().trim())
				&& StringUtils.hasLength(request.getImage().trim())
				&& request.getPrice() != null
				&& StringUtils.hasLength(request.getCategory().trim()) 
				&& StringUtils.hasLength(request.getInventoryStatus().trim())							
				&& request.getRating() != null){

			Restaurant hotel = Restaurant.builder()
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
