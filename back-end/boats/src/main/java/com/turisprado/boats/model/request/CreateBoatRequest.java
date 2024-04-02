package com.turisprado.boats.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoatRequest {

	private String code;
	private String name;
	private String description;
	private String image;	
	private Integer price;
	private String category;
	private Integer quantity;
	private String inventoryStatus;
	private Integer rating;
	
}
