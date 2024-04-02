package com.turisprado.boats.service;

import java.util.List;

import com.turisprado.boats.model.pojo.Reserve;
import com.turisprado.boats.model.request.CreateReserveRequest;

public interface ReserveService {

	Reserve createReserve(CreateReserveRequest request);
	List<Reserve> getReserves();
	List<Reserve> getReservesBoat();
	
}
