package com.turisprado.hotels.service;

import java.util.List;

import com.turisprado.hotels.model.pojo.Image;

public interface ImageService {

	List<Image> getFindByIdhotel(Long hotelId);
}
