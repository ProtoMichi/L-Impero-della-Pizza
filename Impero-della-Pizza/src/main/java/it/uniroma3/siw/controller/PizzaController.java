package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		model.addAttribute("pizzas", this.pizzaService.getAllPizzas());
		return "pizzas.html";
	}
	
	@GetMapping("/")
	public String getHomepage() {
		return "homepage.html";
	}
}
