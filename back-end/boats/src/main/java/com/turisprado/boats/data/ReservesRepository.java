package com.turisprado.boats.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turisprado.boats.model.pojo.Reserve;

public interface ReservesRepository extends JpaRepository<Reserve, Long>{

	@Query(value = "SELECT  r.id, r.name, r.lastname, b.name as enterprise,  d.name as boat, r.dateini, r.time, r.email, r.idroom, r.phone\r\n"
			+ "FROM reserve_boat r\r\n"
			+ "INNER JOIN boat_detail d\r\n"
			+ "ON r.idroom = d.id\r\n"
			+ "INNER JOIN boats b\r\n"
			+ "ON d.idboat = b.id", nativeQuery = true)
	List<Reserve> findByIdBoat();
}
