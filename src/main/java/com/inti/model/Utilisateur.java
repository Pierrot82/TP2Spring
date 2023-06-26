package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Utilisateur {
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
}
