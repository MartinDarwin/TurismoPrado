package com.turisprado.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turisprado.hotels.data.ImagesRepository;
import com.turisprado.hotels.model.pojo.Image;


@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImagesRepository repository;
	
	@Override
	public List<Image> getFindByIdhotel(Long hotelId) {
		List<Image> images = repository.findByIdhotel(hotelId);
		return images.isEmpty() ? null : images;		
	}

}
