package com.inti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity @Table @Data
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, length = 3, nullable = false)
	@NonNull
	private int numChambre;
	private double superficie;
	@Column(unique = true, length = 3, nullable = false)
	@NonNull
	private int etage;
	@NonNull
	private boolean disponnibilité;
	private double prix;
	
	
	
	
}
