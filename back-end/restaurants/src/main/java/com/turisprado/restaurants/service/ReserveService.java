package com.turisprado.restaurants.service;

import java.util.List;

import com.turisprado.restaurants.model.pojo.Reserve;
import com.turisprado.restaurants.model.request.CreateReserveRequest;

public interface ReserveService {

	Reserve createReserve(CreateReserveRequest request);
	List<Reserve> getReserves();
	List<Reserve> getReservesRestaurant();
	
}
