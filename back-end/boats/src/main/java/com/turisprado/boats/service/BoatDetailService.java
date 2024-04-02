package com.turisprado.boats.service;

import java.util.List;

import com.turisprado.boats.model.pojo.BoatDetail;

public interface BoatDetailService {
	
	List<BoatDetail> getBoatdetails();
	
	List<BoatDetail> getFindByName(String name);
	
	List<BoatDetail> getFindByIdboat(Long boatId);


}
