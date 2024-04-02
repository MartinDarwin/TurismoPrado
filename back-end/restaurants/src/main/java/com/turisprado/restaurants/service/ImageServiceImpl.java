package com.turisprado.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turisprado.restaurants.data.ImagesRepository;
import com.turisprado.restaurants.model.pojo.Image;


@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImagesRepository repository;
	
	@Override
	public List<Image> getFindByrestaurantId(Long restaurantId) {
		List<Image> images = repository.findByIdrestaurant(restaurantId);
		return images.isEmpty() ? null : images;		
	}

}
