package com.turisprado.restaurants.service;

import java.util.List;

import com.turisprado.restaurants.model.pojo.Dish;

public interface DishService {
	
	List<Dish> getDishs();
	
	List<Dish> getFindByName(String name);
	
	List<Dish> getFindByIdrestaurant(Long restaurantId);


}
