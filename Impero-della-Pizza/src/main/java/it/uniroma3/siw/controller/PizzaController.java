package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.service.PizzaService;
import jakarta.validation.Valid;

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
	public String showPizze(Model model) {
		model.addAttribute("pizze", this.pizzaService.getAllPizzas());
		return "pizze.html";
	}
	
	@GetMapping("/formNewPizza")
	public String formNewPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "formNewPizza.html";
	}
	
	@PostMapping("/pizza")
	public String newPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "formNewPizza.html";
		} 
		else {
			this.pizzaService.save(pizza);
			model.addAttribute("pizza", pizza);
			return "redirect:pizza/" + pizza.getId();
		}
	}
	
	@GetMapping("/admin/homePizza")
	public String homePizza() {
		return "admin/homePizza.html";
	}
	
	
}
