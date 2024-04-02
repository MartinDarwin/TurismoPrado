package com.turisprado.restaurants.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.restaurants.model.pojo.Restaurant;

public interface RestaurantsRepository extends JpaRepository<Restaurant, Long>{

}
