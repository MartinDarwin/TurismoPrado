package com.turisprado.hotels.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turisprado.hotels.model.pojo.ReserveRoomHotel;
import com.turisprado.hotels.model.pojo.Reserve;

public interface ReservesRepository extends JpaRepository<Reserve, Long> {

	@Query(value = "SELECT s.id as id, s.name, s.lastname, s.email as email, s.phone as phone, h.name as hotel, r.name as habitacion, s.dateini, s.dateend, r.id as idroom from reserve_hotel s INNER JOIN room r on s.idroom = r.id INNER JOIN hotel h on h.id = r.idhotel", nativeQuery = true)
	List<Reserve> findByIdRoom();

}
