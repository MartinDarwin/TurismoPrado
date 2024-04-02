package com.turisprado.boats.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turisprado.boats.model.pojo.Boat;

public interface BoatsRepository extends JpaRepository<Boat, Long>{

}
