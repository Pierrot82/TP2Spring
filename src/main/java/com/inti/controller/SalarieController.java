package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.inti.model.Salarie;
import com.inti.repository.SalarieRepository;

@Controller 
public class SalarieController {

    @Autowired
    SalarieRepository salarieRepository;

    @GetMapping("creerSalarie")
    public String creerSalarie(Model model) {
        model.addAttribute("salarie", new Salarie());
        return "creerSalarie";
    }

    @PostMapping("creerSalarie")
    public String creerSalarie(@ModelAttribute("salarie") Salarie salarie) {
        salarieRepository.save(salarie);
        return "redirect:/salarie/listeSalarie";
    }

    @GetMapping("modifierSalarie/{id}")
    public String modifierSalarie(@PathVariable("id") int id, Model model) {
        Salarie salarie = salarieRepository.findById(id).orElse(null);
        model.addAttribute("salarie", salarie);
        return "modifierSalarie";
    }

    @PostMapping("modifierSalarie")
    public String modifierSalarie(@ModelAttribute("salarie") Salarie salarie) {
        salarieRepository.save(salarie);
        return "redirect:/salarie/listeSalarie";
    }

    @GetMapping("supprimerSalarie/{id}")
    public String supprimerSalarie(@PathVariable("id") int id) {
		salarieRepository.delete(salarieRepository.getById(id));
        return "redirect:/salarie/listeSalarie";
    }
    
    @GetMapping("listeSalarie")
    public String listeSalarie(Model model) {
        List<Salarie> salaries = salarieRepository.findAll();
        model.addAttribute("salaries", salaries);
        return "listeSalaries";
}
}
