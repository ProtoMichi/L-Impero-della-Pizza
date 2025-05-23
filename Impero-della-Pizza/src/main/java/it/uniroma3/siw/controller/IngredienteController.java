package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.IngredienteService;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("/ingrediente")
	public String getIngredienti(Model model) {
		model.addAttribute("ingredienti",this.ingredienteService.getAllIngredienti());
		return "ingredienti.html";
	}
	
	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id,Model model) {
		model.addAttribute("ingrediente",this.ingredienteService.getIngredientebyId(id));
		return "ingrediente.html";
	}
	
	@GetMapping("/formNewIngrediente")
	public String formNewIngrediente(Model model) {
		model.addAttribute("ingrediente",new Ingrediente());
		return "formNewIngrediente.html";
	}
	
	@PostMapping("/ingrediente")
	public String newIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente,Model model) {
		this.ingredienteService.save(ingrediente);
		return "redirect:ingrediente/"+ingrediente.getId();
	}
}
