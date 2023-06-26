package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Utilisateur;

@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Utilisateur findByUsername(String username);
}
