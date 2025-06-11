package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
	
	@Autowired
	RecensioneService recensioneService;
	//da lasciare, potrebbe interessarci una recensione singola
	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recensione", this.recensioneService.getRecensioneById(id));
		return "recensione.html";
	}
	//da lsciare, così che abbiamo un elenco di recensioni
	@GetMapping("/recensioni")
	public String showRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "recensioni.html";
	}
	
	
	@GetMapping("/admin/gestioneRecensioni")
	public String getGestioneRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "admin/gestioneRecensioni.html";
	}
	
	@GetMapping("/admin/homeRecensione")
	public String homeRecensione() {
		return "admin/homeRecensione.html";
	}
	
	@PostMapping("/admin/gestioneRecensione/delete")
	public String eliminaRecensione(@RequestParam("id") Long id) {
		recensioneService.deleteById(id);
		return "redirect:/admin/gestioneRecensioni";
	}
}
