package com.turisprado.boats.model.pojo;

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
@Table(name = "reserve_boat")
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
	
	@Column(name = "dateini", length = 30)
	private String dateini;
	
	@Column(name = "time")
	private Integer time;
	
	@Column(name = "idroom")
	private Integer idroom;
	
	@Column(name = "enterprise", length = 250)
	private String enterprise;
	
	@Column(name = "boat", length = 250)
	private String boat;
}
