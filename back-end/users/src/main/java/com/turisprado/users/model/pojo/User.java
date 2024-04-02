package com.turisprado.users.model.pojo;


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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 80)
	private String name;
	
	@Column(name = "lastname", length = 80)
	private String lastname;
	
	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "email", length = 40)
	private String email;
	
	@Column(name = "username", length = 20)
	private String username;
	
	@Column(name = "password", length = 20)
	private String password;
	
	@Column(name = "type", length = 20)
	private String type;
}


