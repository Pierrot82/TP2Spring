package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Salarie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String type;
	private LocalDate dateNaissance;
	private LocalDate dateEmbauche;
	
	public Salarie(String nom, String prenom, String type, LocalDate dateNaissance, LocalDate dateEmbauche) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.dateNaissance = dateNaissance;
		this.dateEmbauche = dateEmbauche;
	}
	
	

}
