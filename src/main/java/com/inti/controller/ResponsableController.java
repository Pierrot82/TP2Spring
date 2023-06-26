package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Responsable;
import com.inti.repository.ResponsableRepository;

@Controller
public class ResponsableController {
	@Autowired
	ResponsableRepository responsableRepository;
	
	@Secured("ROLE_CLIENT")
	@GetMapping("/afficherResponsables") 
	public String afficherResponsables(Model model) {
		model.addAttribute("responsable", responsableRepository.findAll());
		return "afficherResponsables";
	}
	
	@Secured("{ROLE_RESPONSABLE, ROLE_SALARIE")
	@GetMapping("/modifierResponsable/{id}")
	public String modifierResponsable(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("responsable", responsableRepository.findById(id).get());
		return "modifierResponsable";
	}

	@Secured("{ROLE_RESPONSABLE, ROLE_SALARIE")
	@PostMapping("/modifierResponsable/{id}") 
	public String updateResponsable (@ModelAttribute("responsable") Responsable responsable)
	{
		responsableRepository.save(responsable);
		return "redirect:/";
	}
	
}
