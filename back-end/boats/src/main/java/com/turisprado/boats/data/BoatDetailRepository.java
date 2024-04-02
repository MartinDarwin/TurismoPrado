package com.turisprado.boats.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.boats.model.pojo.BoatDetail;

public interface BoatDetailRepository extends JpaRepository<BoatDetail, Long>{
	
	List<BoatDetail> findByName(String name);
	
	List<BoatDetail> findByIdboat(Long boatId);
}
