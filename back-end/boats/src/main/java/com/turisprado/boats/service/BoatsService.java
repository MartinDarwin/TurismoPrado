package com.turisprado.boats.service;

import java.util.List;

import com.turisprado.boats.model.pojo.Boat;
import com.turisprado.boats.model.request.CreateBoatRequest;

public interface BoatsService {

	List<Boat> getBoats();
	
	Boat getBoat(String boatId);
	
	Boolean removeBoat(String boatId);
	
	Boat createBoat(CreateBoatRequest request);
}
