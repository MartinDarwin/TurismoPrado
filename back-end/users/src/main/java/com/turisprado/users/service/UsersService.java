package com.turisprado.users.service;

import java.util.List;

import com.turisprado.users.model.pojo.User;
import com.turisprado.users.model.request.CreateUserRequest;

public interface UsersService {

	List<User> getUsers();
	
	User getUser(String userId);
	
	Boolean removeUser(String userId);
	
	User createUser(CreateUserRequest request);
	
	User findByUsername(String username);
}
