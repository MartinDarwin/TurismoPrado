package com.turisprado.boats.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.boats.model.pojo.Image;


public interface ImagesRepository extends JpaRepository<Image, Long>{

	List<Image> findByIdboat(Long boatId);
	
}
