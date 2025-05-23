package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.service.PizzaService;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizza/{id}")
	public String getPizza(@PathVariable("id") Long id, Model model) {
		model.addAttribute("pizza", this.pizzaService.getPizzabyId(id));
		return "pizza.html";
	}
	
	@GetMapping("/pizza")
	public String showPizzas(Model model) {
		model.addAttribute("pizze", this.pizzaService.getAllPizzas());
		return "pizze.html";
	}
	
	@GetMapping("/formNewPizza")
	public String formNewPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "formNewPizza.html";
	}
	
	@PostMapping("/pizza")
	public String newPizza(@ModelAttribute("pizza") Pizza pizza,Model model) {
		this.pizzaService.save(pizza);
		return "redirect:pizza/" + pizza.getId();
	}
	
	@GetMapping("/")
	public String getHomepage() {
		return "homepage.html";
	}
}
