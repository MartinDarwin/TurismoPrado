package com.turisprado.users.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

	private String id;
	private String name;
	private String lastname;
	private String phone;	
	private String email;
	private String username;
	private String password;
	private String type;
	
}
