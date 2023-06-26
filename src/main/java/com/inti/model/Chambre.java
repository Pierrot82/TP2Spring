package com.inti.model;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
