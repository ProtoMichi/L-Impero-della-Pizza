package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	    if (credentials == null || credentials.getUser() == null) {
	        return "pizzaNonTrovata.html"; // inserire errore
	    }

	    User user = credentials.getUser();
	    List<Recensione> recensioni = this.recensioneService.getByAutore(user);

	    model.addAttribute("recensioni", recensioni);
	    model.addAttribute("utente", user);
	    return "recensioniUtente.html";
	}

	@GetMapping("/admin/formGestioneRecensioni")
	public String getGestioneRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "admin/formGestioneRecensioni.html";
	}
	
	@PostMapping("/admin/gestioneRecensione/delete")
	public String eliminaRecensione(@RequestParam("id") Long id) {
		recensioneService.deleteById(id);
		return "redirect:/admin/formGestioneRecensioni";
	}
	
	@PostMapping("/recensioni/{username}/recensioni/delete")
	public String eliminaRecensioneUtente(@RequestParam("id") Long id, @PathVariable("username") String username, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
	    if (credentials == null || credentials.getUser() == null) {
	        return "pizzaNonTrovata.html"; // inserire errore
	    }
		recensioneService.deleteById(id);
		User user = credentials.getUser();
	    List<Recensione> recensioni = this.recensioneService.getByAutore(user);

	    model.addAttribute("recensioni", recensioni);
	    model.addAttribute("utente", user);
		return "recensioniUtente.html";
	}
}
