package com.turisprado.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.restaurants.data.ReservesRepository;
import com.turisprado.restaurants.model.pojo.Reserve;
import com.turisprado.restaurants.model.pojo.Restaurant;
import com.turisprado.restaurants.model.request.CreateReserveRequest;


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
				&& request.getNumdish() != null
				&& StringUtils.hasLength(request.getDateini().trim())
				&& request.getIddish() != null){
			
			String diaini = request.getDateini().substring(0,10) + " / " + request.getDateini().substring(11,16) + " hrs";

			Reserve reserve = Reserve.builder()
					.name(request.getName())
					.lastname(request.getLastname())
					.phone(request.getPhone())
					.email(request.getEmail())
					.numdish(request.getNumdish())
					.dateini(diaini)
					.iddish(request.getIddish()).build();

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
	public List<Reserve> getReservesRestaurant() {
		List<Reserve> reserves = repository.findByIdDish();
		return reserves.isEmpty() ? null : reserves;
	}

}
