package com.turisprado.restaurants.service;

import java.util.List;

import com.turisprado.restaurants.model.pojo.Image;

public interface ImageService {

	List<Image> getFindByrestaurantId(Long restaurantId);
}
