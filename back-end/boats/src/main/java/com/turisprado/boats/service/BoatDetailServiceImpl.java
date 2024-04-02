package com.turisprado.boats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turisprado.boats.data.BoatDetailRepository;
import com.turisprado.boats.model.pojo.BoatDetail;

@Service
public class BoatDetailServiceImpl implements BoatDetailService {

	@Autowired
	private BoatDetailRepository repository;
	
	@Override
	public List<BoatDetail> getBoatdetails() {
		List<BoatDetail> boatdetail = repository.findAll();
		return boatdetail.isEmpty() ? null : boatdetail;
	}

	@Override
	public List<BoatDetail> getFindByName(String name) {
		List<BoatDetail> boatdetail = repository.findByName(name);
		return boatdetail.isEmpty() ? null : boatdetail;
	}

	@Override
	public List<BoatDetail> getFindByIdboat(Long boatId) {
		List<BoatDetail> boatdetail = repository.findByIdboat(boatId);
		return boatdetail.isEmpty() ? null : boatdetail;
	}
	
}
