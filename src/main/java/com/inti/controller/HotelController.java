package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;


@Controller
public class HotelController {
	
	@Autowired
	IHotelRepository ihr;
	
	@GetMapping("creerHotel")
	public String formHotel() {
		return "creerHotel";
	}

	@PostMapping("creerHotel")
	public String saveHotel(@ModelAttribute("hotel") Hotel h) {
		ihr.save(h);
		return "redirect:listeHotel";
	}

	@GetMapping("listeHotel")
	public String listeHotel(Model m) {
		m.addAttribute("listeHotel", ihr.findAll().toArray());
		return "listeHotel";
	}

	
	@GetMapping("deleteHotel/{id}")
	public String deleteHotel(@PathVariable("id") int id) {
		ihr.deleteById(id);
		return "redirect:/listeHotel";
	}
	
	@GetMapping("modifierHotel/{id}")
	public String modifierHotel(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("hotel", ihr.findById(id).get());
		return "/modifierHotel";
	}
	
	@PostMapping("modifierHotel")
	public String updateHotel(@ModelAttribute("hotel") Hotel h)
	{
		ihr.save(h); // = saveOrUpdate
		return "redirect:listeHotel";
	}
	
//	@GetMapping("getHotel/{idHotel}")
//	public String getConcert(@PathVariable("idHotel") int idHotel, Model m)
//	{
//		m.addAttribute("h1", ihr.findById(idHotel).get());
//		
//		return "getHotel";
//	}
	

}
