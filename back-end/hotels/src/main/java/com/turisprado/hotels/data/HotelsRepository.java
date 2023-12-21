package com.turisprado.hotels.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.hotels.model.pojo.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Long>{

}
