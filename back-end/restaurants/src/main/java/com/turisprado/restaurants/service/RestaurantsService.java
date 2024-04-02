package com.turisprado.restaurants.service;

import java.util.List;

import com.turisprado.restaurants.model.pojo.Restaurant;
import com.turisprado.restaurants.model.request.CreateRestaurantRequest;

public interface RestaurantsService {

	List<Restaurant> getRestaurants();
	
	Restaurant getRestaurant(String hotelId);
	
	Boolean removeRestaurant(String hotelId);
	
	Restaurant createRestaurant(CreateRestaurantRequest request);
}
