package com.turisprado.boats.service;

import java.util.List;

import com.turisprado.boats.model.pojo.Image;

public interface ImageService {

	List<Image> getFindByIdboat(Long boatId);
}
