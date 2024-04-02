package com.turisprado.restaurants.model.pojo;

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
@Table(name = "reserve_restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Reserve {

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

	@Column(name = "numdish")
	private Integer numdish;
	
	@Column(name = "dateini", length = 30)
	private String dateini;
	
	@Column(name = "iddish")
	private Integer iddish;
	
	@Column(name = "restaurant", length = 250)
	private String restaurant;
	
	@Column(name = "dish", length = 250)
	private String dish;
}
