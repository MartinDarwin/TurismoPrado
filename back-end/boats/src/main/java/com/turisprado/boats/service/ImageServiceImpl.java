package com.turisprado.boats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turisprado.boats.data.ImagesRepository;
import com.turisprado.boats.model.pojo.Image;


@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImagesRepository repository;
	
	@Override
	public List<Image> getFindByIdboat(Long boatId) {
		List<Image> images = repository.findByIdboat(boatId);
		return images.isEmpty() ? null : images;		
	}

}
