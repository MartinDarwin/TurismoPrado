package com.turisprado.hotels.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.hotels.model.pojo.Image;


public interface ImagesRepository extends JpaRepository<Image, Long>{

	List<Image> findByIdhotel(Long hotelId);
	
}
