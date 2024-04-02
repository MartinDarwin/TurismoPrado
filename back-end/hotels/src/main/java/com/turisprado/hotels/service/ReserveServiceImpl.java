package com.turisprado.hotels.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.hotels.data.ReservesRepository;
import com.turisprado.hotels.model.pojo.Hotel;
import com.turisprado.hotels.model.pojo.Reserve;
import com.turisprado.hotels.model.pojo.ReserveRoomHotel;
import com.turisprado.hotels.model.request.CreateReserveRequest;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReservesRepository repository;

	@Override
	public Reserve createReserve(CreateReserveRequest request) {

		if (request != null && StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getLastname().trim())
				&& StringUtils.hasLength(request.getPhone().trim()) && StringUtils.hasLength(request.getEmail().trim())
				&& StringUtils.hasLength(request.getDateini().trim())
				&& StringUtils.hasLength(request.getDateend().trim()) && request.getIdroom() != null) {

			String diaini = request.getDateini().substring(0, 10) + " / " + request.getDateini().substring(11, 16)
					+ " hrs";
			String diafin = request.getDateend().substring(0, 10) + " / " + request.getDateend().substring(11, 16)
					+ " hrs";

			Reserve reserve = Reserve.builder().name(request.getName()).lastname(request.getLastname())
					.phone(request.getPhone()).email(request.getEmail()).dateini(diaini).dateend(diafin)
					.idroom(request.getIdroom()).build();

			return repository.save(reserve);
		} else {
			return null;
		}
	}

	@Override
	public List<Reserve> getReserves() {
		List<Reserve> reserves = repository.findAll();
		return reserves.isEmpty() ? null : reserves;
	}

	@Override
	public List<Reserve> getReservesHotel() {
		List<Reserve> reserves = repository.findByIdRoom();
		System.out.println("ReserveRoomHotel.getName = " + Reserve.builder().toString().trim());
		return reserves.isEmpty() ? null : reserves;
	}

}
