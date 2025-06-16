package it.uniroma3.siw.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.IngredienteService;
import jakarta.validation.Valid;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	@Autowired
	private CredentialsService credentialsService;

	@GetMapping("/ingrediente")
	public String getIngredienti(Model model) {
		model.addAttribute("ingredienti",this.ingredienteService.getAllIngredienti());
		return "ingredienti.html";
	}

	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id,Model model,Principal principal) {
		Ingrediente ingrediente = this.ingredienteService.getIngredienteById(id);
		if(ingrediente==null) {
			return "pizzaNonTrovata.html";
		}
		
		model.addAttribute("ingrediente",ingrediente);

		if (principal != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
			model.addAttribute("ruolo", credentials.getRuolo());
		}
		return "ingrediente.html";
	}

	@GetMapping("/admin/formNewIngrediente")
	public String formNewIngrediente(Model model) {
		model.addAttribute("ingrediente",new Ingrediente());
		return "admin/formNewIngrediente.html";
	}

	@PostMapping("/admin/ingrediente")
	public String newIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "admin/formNewIngrediente.html";
		}
		else {
			this.ingredienteService.save(ingrediente);
			model.addAttribute("ingrediente",ingrediente);
			return "redirect:/ingrediente/"+ingrediente.getId();
		}
	}


	@GetMapping("/admin/homeIngrediente")
	public String homeIngrediente() {
		return "admin/homeIngrediente.html";
	}

	@GetMapping("/ingrediente/{id}/modifica")
	public String modificaIngrediente(@PathVariable Long id, Model model, Principal principal) {
		Ingrediente ingrediente = this.ingredienteService.getIngredienteById(id);
		if(ingrediente==null) {
			return "pizzaNonTrovata.html";
		}
		
		if (principal == null) {
			return "redirect:/login";
		}

		model.addAttribute("ingrediente", ingrediente);
		model.addAttribute("ingredientiEsistenti", this.ingredienteService.getAllIngredienti());
		return "admin/formModificaIngrediente.html";
	}

	@PostMapping("/ingrediente/{id}/modifica")
	public String aggiornaIngrediente(@PathVariable("id") Long id,  @ModelAttribute("ingrediente") Ingrediente ingredienteAggiornato, BindingResult bindingResult,  Model model,  Principal principal) {
		if (principal == null) {
			return "redirect:/login";
		}
		Ingrediente ingredienteEsistente = ingredienteService.getIngredienteById(id);
		this.ingredienteService.updateIngrediente(ingredienteEsistente, ingredienteAggiornato);
		return "redirect:/ingrediente/" + id;
	}
}
