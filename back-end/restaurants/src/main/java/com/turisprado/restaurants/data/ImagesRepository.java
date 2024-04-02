package com.turisprado.restaurants.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.restaurants.model.pojo.Image;


public interface ImagesRepository extends JpaRepository<Image, Long>{

	List<Image> findByIdrestaurant(Long restaurantId);
	
}
