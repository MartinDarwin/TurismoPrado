package com.turisprado.boats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.boats.data.ReservesRepository;
import com.turisprado.boats.model.pojo.Boat;
import com.turisprado.boats.model.pojo.Reserve;
import com.turisprado.boats.model.request.CreateReserveRequest;


@Service
public class ReserveServiceImpl implements ReserveService{

	@Autowired
	private ReservesRepository repository;
	
	@Override
	public Reserve createReserve(CreateReserveRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getLastname().trim())
				&& StringUtils.hasLength(request.getPhone().trim())
				&& StringUtils.hasLength(request.getEmail().trim()) 
				&& StringUtils.hasLength(request.getDateini().trim())
				&& request.getTime() != null
				&& request.getIdroom() != null){
			
			String diaini = request.getDateini().substring(0,10) + " / " + request.getDateini().substring(11,16) + " hrs";

			Reserve reserve = Reserve.builder()
					.name(request.getName())
					.lastname(request.getLastname())
					.phone(request.getPhone())
					.email(request.getEmail())
					.dateini(diaini)
					.time(request.getTime())
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
	public List<Reserve> getReservesBoat() {
		List<Reserve> reserves = repository.findByIdBoat();
		return reserves.isEmpty() ? null : reserves;
	}

}
