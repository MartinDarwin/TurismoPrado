package com.turisprado.hotels.model.pojo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReserveRoomHotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", length = 80)
	private String name;
	
	@Column(name = "lastname", length = 80)
	private String lastname;
	
	@Column(name = "hotel", length = 250)
	private String hotel;

	@Column(name = "habitacion", length = 250)
	private String habitacion;
	
	@Column(name = "dateini", length = 30)
	private String dateini;
	
	@Column(name = "dateend", length = 30)
	private String dateend;
	
	@Column(name = "idroom")
	private Integer idroom;
	
}