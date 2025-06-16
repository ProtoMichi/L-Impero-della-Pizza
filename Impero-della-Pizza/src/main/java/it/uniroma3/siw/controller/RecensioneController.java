package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.RecensioneService;
import it.uniroma3.siw.service.UserService;

@Controller
public class RecensioneController {
	
	@Autowired
	RecensioneService recensioneService;
	@Autowired
	private UserService userService;
	@Autowired
	private CredentialsService credentialsService;
	
	
	//da lasciare, potrebbe interessarci una recensione singola
	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") Long id, Model model) {
		Recensione recensione = this.recensioneService.getRecensioneById(id);
		if(recensione==null) {
			return "pizzaNonTrovata.html"; //inserire errore
		}
		model.addAttribute("recensione", recensione);
		return "recensione.html";
	}
	//da lsciare, così che abbiamo un elenco di recensioni
	@GetMapping("/recensione")
	public String showRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "recensioni.html";
	}
	
	@GetMapping("/recensione/{username}/recensioni")
	public String recensioniUtente(@PathVariable("username") String username, Model model) {
		Credentials credentials = this.credentialsService.getCredentials(username);
		if(credentials == null) {
			return "pizzaNonTrovata.html"; //inserire errore
		}
	    List<Recensione> recensioni = this.recensioneService.getByAutore(credentials);
	    model.addAttribute("recensioni", recensioni);
	    model.addAttribute("utente", credentials);
	    return "recensioniUtente.html";
	}

	
	
	@GetMapping("/admin/formGestioneRecensioni")
	public String getGestioneRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "admin/formGestioneRecensioni.html";
	}
	
	@GetMapping("/admin/homeRecensione")
	public String homeRecensione() {
		return "admin/homeRecensione.html";
	}
	
	@PostMapping("/admin/gestioneRecensione/delete")
	public String eliminaRecensione(@RequestParam("id") Long id) {
		recensioneService.deleteById(id);
		return "redirect:/admin/formGestioneRecensioni";
	}
}
