package com.turisprado.restaurants.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turisprado.restaurants.model.pojo.Reserve;

public interface ReservesRepository extends JpaRepository<Reserve, Long>{

	@Query(value = "SELECT r.id as id, r.name, r.lastname, t.name as restaurant, r.email as email, r.phone as phone, s.name as dish, r.dateini as dateini, r.numdish, r.iddish FROM reserve_restaurant r\r\n"
			+ "INNER JOIN dish s\r\n"
			+ "ON r.iddish = s.id\r\n"
			+ "INNER JOIN restaurant t\r\n"
			+ "ON t.id = s.idrestaurant", nativeQuery = true)
	List<Reserve> findByIdDish();
}
