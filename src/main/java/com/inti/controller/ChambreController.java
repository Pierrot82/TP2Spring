package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Chambre;
import com.inti.repository.IChambreRepository;

@Controller
public class ChambreController {

	@Autowired
	IChambreRepository icr;
	
	//Create
		@GetMapping("/ajouterChambre")
		public String FormulaireAjoutChambre(Model model) {
			model.addAttribute("chambre", new Chambre());
			return "ajouterChambre";
		}

		@PostMapping("/ajouterChambre")
		public String ajouterChef(@ModelAttribute Chambre chambre) {
			icr.save(chambre);
			return "redirect:/listeChambre";
		}

	//Read
		@GetMapping("/listeChambre")
		public String afficherListeChambre(Model model) {
			model.addAttribute("chefs", icr.findAll());
			return "listeChambre";
		}

	//Update
		@GetMapping("/modifierChambre/{id}")
		public String FormulaireModificationChambre(@PathVariable("id") int id, Model model) {
			model.addAttribute("c1", icr.getById(id));
			return "modifierChambre";
		}

		@PostMapping("/modifierChambre/{id}")
		public String modifierChambre(@PathVariable("id") int id, @ModelAttribute Chambre chambre) {
			icr.save(chambre);
			return "redirect:/listeChambre";
		}

	//Delete
		@GetMapping("/supprimerChambre/{id}")
		public String supprimerChef(@PathVariable("id") int id) {
			icr.deleteById(id);
			return "redirect:/liste";
		}
}
