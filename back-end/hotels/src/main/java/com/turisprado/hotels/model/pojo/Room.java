package com.turisprado.hotels.model.pojo;

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
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 250)
	private String name;
	
	@Column(name = "description", length = 1000)
	private String description;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "category", length = 30)
	private String category;

	@Column(name = "inventoryStatus", length = 20)
	private String inventoryStatus;
	
	@Column(name = "idhotel")
	private Integer idhotel;
}
