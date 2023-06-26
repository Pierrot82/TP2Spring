package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Client;
import com.inti.repository.IClientRepository;

@Controller
public class MainController {
	@Autowired
	IClientRepository iClientRepository;
	
	@GetMapping("/signup")
	public String creerCompte() {
		return "creerClient";
	}
	@PostMapping("/signup")
	public String creerCompteUtilisateur(@ModelAttribute("client") Client client) {
		iClientRepository.save(client);
		return "/";
	}
}
