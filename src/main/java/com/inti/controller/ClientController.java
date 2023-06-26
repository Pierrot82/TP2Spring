package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Client;
import com.inti.repository.IClientRepository;

@Controller
public class ClientController {
	@Autowired
	IClientRepository iClientRepository;
	
	@Secured("ROLE_CLIENT")
	@GetMapping("/afficherClients") 
	public String afficherClients(Model model) {
		model.addAttribute("client", iClientRepository.findAll());
		return "afficherClients";
	}
	
	@Secured("{ROLE_RESPONSABLE, ROLE_SALARIE")
	@GetMapping("/modifierClient/{id}")
	public String modifierClient(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("client", iClientRepository.findById(id).get());
		return "modifierClient";
	}

	@Secured("{ROLE_RESPONSABLE, ROLE_SALARIE")
	@PostMapping("/modifierClient/{id}") 
	public String updateClient (@ModelAttribute("client") Client client)
	{
		iClientRepository.save(client);
		return "redirect:/";
	}
	
	@Secured("{ROLE_RESPONSABLE, ROLE_SALARIE")
	@PostMapping("/supprimerClient/{id}") 
	public String supprimerClient (@ModelAttribute("client") Client client)
	{
		iClientRepository.delete(client);
		return "redirect:/";
	}
}
