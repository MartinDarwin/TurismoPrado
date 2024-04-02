package com.turisprado.restaurants.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReserveRequest {

	private String name;
	private String lastname;
	private String phone;
	private String email;
	private Integer numdish;
	private String dateini;	
	private Integer iddish;

}
