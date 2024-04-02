package com.turisprado.boats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.boats.data.BoatsRepository;
import com.turisprado.boats.model.pojo.Boat;
import com.turisprado.boats.model.request.CreateBoatRequest;



@Service
public class BoatsServiceImpl implements BoatsService {

	@Autowired
	private BoatsRepository repository;
	
	@Override
	public List<Boat> getBoats() {
		List<Boat> hotels = repository.findAll();
		return hotels.isEmpty() ? null : hotels;
	}

	@Override
	public Boat getBoat(String boatId) {
		return repository.findById(Long.valueOf(boatId)).orElse(null);
	}

	@Override
	public Boolean removeBoat(String boatId) {
		return null;
	}

	@Override
	public Boat createBoat(CreateBoatRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getDescription().trim())
				&& StringUtils.hasLength(request.getImage().trim())
				&& request.getPrice() != null
				&& StringUtils.hasLength(request.getCategory().trim()) 
				&& StringUtils.hasLength(request.getInventoryStatus().trim())							
				&& request.getRating() != null){

			Boat boat = Boat.builder()
					.name(request.getName())
					.description(request.getDescription())
					.image(request.getImage())
					.price(request.getPrice())
					.category(request.getCategory())
					.inventoryStatus(request.getInventoryStatus())
					.rating(request.getRating()).build();

			return repository.save(boat);
		} else {
			return null;
		}
	}

}
