package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class RecensioneController {
	
	@Autowired
	RecensioneService recensioneService;
	//da rimuovere perchè non c'interessa una recensione singola
	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recensione", this.recensioneService.getRecensioneById(id));
		return "recensione.html";
	}
	//da lsciare, così che abbiamo un elenco di recensioni
	@GetMapping("/recensione")
	public String showRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "recensioni.html";
	}
	//da spostare in pizza
//	@GetMapping("/formNewRecensione")
//	public String formNewRecensione(Model model) {
//		model.addAttribute("recensione",new Recensione());
//		return "formNewRecensione.html";
//	}
	//da spostare in pizza
//	@PostMapping("/recensione")
//	public String newRecensione(@Valid @ModelAttribute("recensione") Recensione recensione,
//			BindingResult bindingResult,Model model) {
//		if(bindingResult.hasErrors()) {
//			return "formNewRecensione.html";
//		}
//		else {
//			this.recensioneService.save(recensione);
//			model.addAttribute("recensione", recensione);
//			return "redirect:recensione/"+recensione.getId();
//		}
//	}
	
	@GetMapping("/admin/homeRecensione")
	public String homeRecensione() {
		return "admin/homeRecensione.html";
	}
	
}
