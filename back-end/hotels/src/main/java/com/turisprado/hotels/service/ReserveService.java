package com.turisprado.hotels.service;

import java.util.List;
import com.turisprado.hotels.model.pojo.Reserve;
import com.turisprado.hotels.model.pojo.ReserveRoomHotel;
import com.turisprado.hotels.model.request.CreateReserveRequest;

public interface ReserveService {

	Reserve createReserve(CreateReserveRequest request);
	List<Reserve> getReserves();
	List<Reserve> getReservesHotel();
	
}
