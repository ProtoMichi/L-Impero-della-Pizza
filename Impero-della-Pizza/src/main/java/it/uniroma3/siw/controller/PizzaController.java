package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private IngredienteService ingredienteService;

	@Autowired
	private RecensioneService recensioneService;

	@GetMapping("/pizza/{id}")
	public String getPizza(@PathVariable("id") Long id, Model model) {
		Pizza pizza = this.pizzaService.getPizzabyId(id);
		pizza.calcolaPrezzo();
		List <Recensione> reversed = pizza.getListaRecensioni();
		Collections.reverse(reversed);
		pizza.setListaRecensioni(reversed);
		model.addAttribute("pizza", pizza);
		return "pizza.html";
	}

	@GetMapping("/pizza")
	public String showPizze(Model model) {
		List<Pizza> pizze = (List<Pizza>) this.pizzaService.getAllPizzas();
	    
	    // Calcola il prezzo per ogni pizza
	    for (Pizza pizza : pizze) {
	        pizza.calcolaPrezzo();
	    }

		model.addAttribute("pizze",pizze);
		return "pizze.html";
	}

	@GetMapping("/formNewPizza")
	public String formNewPizza(Model model) {
		List<Ingrediente> tuttiIngredientiSenzaFarine = (this.ingredienteService.getAllIngredientiNotFarina());
		model.addAttribute("pizza", new Pizza());
		model.addAttribute("farine",this.ingredienteService.getFarine());
		model.addAttribute("tuttiIngredientiSenzaFarine", tuttiIngredientiSenzaFarine);
		return "formNewPizza.html";
	}

	@PostMapping(value = "/pizza", params = "Conferma")
	public String newPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("farine",this.ingredienteService.getFarine());
			model.addAttribute("tuttiIngredientiSenzaFarine", ingredienteService.getAllIngredientiNotFarina());
			return "formNewPizza.html";
		} 
		else {
			List<Long> ids = new ArrayList<>();
			for (Ingrediente i : pizza.getListaIngredienti()) {
				ids.add(i.getId());
			}
			List<Ingrediente> ingredientiSelezionati = ingredienteService.findAllById(ids);
			pizza.setListaIngredienti(ingredientiSelezionati);
			pizza.calcolaPrezzo();
			this.pizzaService.save(pizza);
			return "redirect:/pizza/" + pizza.getId();
		}
	}

	@PostMapping(value = "/pizza", params = "aggiungiIngrediente")
	public String aggiungiIngrediente(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, 
			@RequestParam(required = false) Long ingredienteSelezionatoId, Model model) {
	    if (bindingResult.hasErrors()) {
	    	model.addAttribute("farine", ingredienteService.getFarine());
	        model.addAttribute("tuttiIngredientiSenzaFarine", ingredienteService.getAllIngredientiNotFarina());
	        return "formNewPizza.html";
	    }
		if(pizza.getListaIngredienti() == null) {
			pizza.setListaIngredienti(new ArrayList<>());
		}
		List<Long> ids = new ArrayList<>();
		for (Ingrediente i : pizza.getListaIngredienti()) {
			ids.add(i.getId());
		}
		List<Ingrediente> ingredientiAttuali = new ArrayList<>(ingredienteService.findAllById(ids));
		if(ingredienteSelezionatoId == null){
            model.addAttribute("erroreIngredienteSelezionato", "Seleziona un ingrediente");
        }
		else{
			Ingrediente nuovo = ingredienteService.getIngredienteById(ingredienteSelezionatoId);
			if (nuovo != null && !ingredientiAttuali.contains(nuovo)) {
				ingredientiAttuali.add(nuovo);
			}
		}
		pizza.setListaIngredienti(ingredientiAttuali);
		model.addAttribute("farine",this.ingredienteService.getFarine());
		model.addAttribute("tuttiIngredientiSenzaFarine", ingredienteService.getAllIngredientiNotFarina());
		model.addAttribute("pizza", pizza);
		return "formNewPizza.html";
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

	@GetMapping("/admin/gestisciPizze")
	public String getListaPizzeDaEliminare(Model model) {
		List<Pizza> pizze = (List<Pizza>) this.pizzaService.getAllPizzas();
		 
		// Calcola il prezzo per ogni pizza
	    for (Pizza pizza : pizze) {
	        pizza.calcolaPrezzo();
	    }

		
	    model.addAttribute("pizze", pizze);
	    return "admin/pizzeAdmin.html";
	}

	@PostMapping("/admin/gestisciPizze/elimina")
	public String eliminaPizze(
	        @RequestParam(name = "pizzeDaEliminare", required = false) List<Long> pizzeDaEliminare) {
	    if (pizzeDaEliminare != null) {
	        for (Long id : pizzeDaEliminare) {
	            pizzaService.deleteById(id);
	        }
	    }
	    return "redirect:/admin/gestisciPizze";
	}

}
