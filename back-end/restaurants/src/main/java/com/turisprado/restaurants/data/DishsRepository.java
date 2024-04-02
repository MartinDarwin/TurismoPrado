package com.turisprado.restaurants.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.restaurants.model.pojo.Dish;

public interface DishsRepository extends JpaRepository<Dish, Long>{
	
	List<Dish> findByName(String name);
	
	List<Dish> findByIdrestaurant(Long restaurantId);
}
