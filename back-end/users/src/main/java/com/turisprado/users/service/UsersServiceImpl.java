package com.turisprado.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turisprado.users.data.UsersRepository;
import com.turisprado.users.model.pojo.User;
import com.turisprado.users.model.request.CreateUserRequest;



@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository repository;
	
	@Override
	public List<User> getUsers() {
		List<User> users = repository.findAll();
		return users.isEmpty() ? null : users;
	}

	@Override
	public User getUser(String userId) {
		return repository.findById(Long.valueOf(userId)).orElse(null);
	}

	@Override
	public Boolean removeUser(String userId) {
		return null;
	}

	@Override
	public User createUser(CreateUserRequest request) {
		if (request != null
				&& StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getLastname().trim())
				&& StringUtils.hasLength(request.getPhone().trim())
				&& StringUtils.hasLength(request.getEmail().trim())
				&& StringUtils.hasLength(request.getUsername().trim()) 
				&& StringUtils.hasLength(request.getPassword().trim())							
				&& StringUtils.hasLength(request.getType().trim())){

			User user = User.builder()
					.name(request.getName())
					.lastname(request.getLastname())
					.phone(request.getPhone())
					.email(request.getEmail())
					.username(request.getUsername())
					.password(request.getPassword())
					.type(request.getType()).build();

			return repository.save(user);
		} else {
			return null;
		}
	}

	@Override
	public User findByUsername(String username) {		
		return repository.findByUsername(username);
	}

}
