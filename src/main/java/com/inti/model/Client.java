package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "idUtilisateur")
@Data
@EqualsAndHashCode(callSuper = false)
public class Client extends Utilisateur {
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
}
