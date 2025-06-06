package it.uniroma3.siw.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.IngredienteService;
import it.uniroma3.siw.service.PizzaService;
import it.uniroma3.siw.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private RecensioneService recensioneService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	
	@GetMapping("/pizza/{id}")
	public String getPizza(@PathVariable("id") Long id, Model model) {
		Pizza pizza = this.pizzaService.getPizzabyIdFetchIngredienti(id);
		System.out.println("Ingredienti caricati: " + pizza.getListaIngredienti());
		List <Recensione> reversed = pizza.getListaRecensioni();
		Collections.reverse(reversed);
		pizza.setListaRecensioni(reversed);
		model.addAttribute("pizza", pizza);
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
		model.addAttribute("farine",this.ingredienteService.getFarine());
		model.addAttribute("ingrediente",this.ingredienteService.getIngredientiExceptFarina());
		return "formNewPizza.html";
	}
	
	@PostMapping("/pizza")
	public String newPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("farine",this.ingredienteService.getFarine());
			model.addAttribute("ingrediente",this.ingredienteService.getIngredientiExceptFarina());
			return "formNewPizza.html";
		} 
		else {
			System.out.println("Ingredienti selezionati: " + pizza.getListaIngredienti()); // Debug
			this.pizzaService.save(pizza);
			return "redirect:/pizza/" + pizza.getId();
		}
	}
	
	@GetMapping("/pizza/{id}/formNewRecensione")
	public String formNewRecensione(@PathVariable("id") Long id , Model model) {
		model.addAttribute("pizza", this.pizzaService.getPizzabyId(id));
		model.addAttribute("recensione",new Recensione());
		return "formNewRecensione.html";
	}
	
	@PostMapping("/pizza/{id}/recensione")
	public String addRecensione(@PathVariable("id") Long id, @Valid @ModelAttribute("recensione") Recensione recensione,
			BindingResult bindingResult, Model model) {
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("pizza", this.pizzaService.getPizzabyId(id));
			return "formNewRecensione.html";
		}
		else {
			Pizza pizza = this.pizzaService.getPizzabyId(id);
			recensione.setId(null);
			recensione.setPizza(pizza);
			this.recensioneService.save(recensione);
			return "redirect:/pizza/"+ pizza.getId();
		}
	}
	
	@GetMapping("/admin/homePizza")
	public String homePizza() {
		return "admin/homePizza.html";
	}
	
}
