package com.turisprado.users.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.users.model.pojo.User;


public interface UsersRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
