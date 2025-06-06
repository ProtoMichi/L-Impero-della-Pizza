package it.uniroma3.siw.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	public Pizza getPizzabyId(Long id) {
		return pizzaRepository.findById(id).get();
	}
	
	public Pizza getPizzabyIdFetchIngredienti(Long id) {
	    return pizzaRepository.findByIdFetchIngredienti(id);
	}
	
	public Iterable<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
	}

	public Pizza save(Pizza pizza) {
	    // Ricostruzione ingredienti
	    List<Ingrediente> ingredientiCompleti = new LinkedList<>();
	    for (Ingrediente ingr : pizza.getListaIngredienti()) {
	        Ingrediente ingredienteCompleto = ingredienteService.getIngredientebyId(ingr.getId());
	        ingredientiCompleti.add(ingredienteCompleto);
	        
	        // Aggiorna il lato inverso della relazione
	        if (ingredienteCompleto.getListaPizze() == null) {
	            ingredienteCompleto.setListaPizze(new LinkedList<>());
	        }
	        if (!ingredienteCompleto.getListaPizze().contains(pizza)) {
	            ingredienteCompleto.getListaPizze().add(pizza);
	        }
	    }
	    pizza.setListaIngredienti(ingredientiCompleti);

	    // Ricostruzione farina
	    if (pizza.getFarina() != null && pizza.getFarina().getId() != null) {
	        Ingrediente farinaCompleta = ingredienteService.getIngredientebyId(pizza.getFarina().getId());
	        pizza.setFarina(farinaCompleta);
	    }

	    return this.pizzaRepository.save(pizza);
	}

}
