package com.turisprado.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turisprado.restaurants.data.DishsRepository;
import com.turisprado.restaurants.model.pojo.Dish;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private DishsRepository repository;
	
	@Override
	public List<Dish> getDishs() {
		List<Dish> rooms = repository.findAll();
		return rooms.isEmpty() ? null : rooms;
	}

	@Override
	public List<Dish> getFindByName(String name) {
		List<Dish> room = repository.findByName(name);
		return room.isEmpty() ? null : room;
	}

	@Override
	public List<Dish> getFindByIdrestaurant(Long restaurantId) {
		List<Dish> room = repository.findByIdrestaurant(restaurantId);
		return room.isEmpty() ? null : room;
	}
	
}
