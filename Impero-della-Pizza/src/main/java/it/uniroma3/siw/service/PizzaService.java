package it.uniroma3.siw.service;

import java.util.LinkedList;

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
	
	public Iterable<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
	}

	public Pizza save(Pizza pizza) {
	    // Salva la pizza (che aggiorna o crea la pizza nel DB)
	    Pizza savedPizza = this.pizzaRepository.save(pizza);

	    // Aggiorna la relazione bidirezionale con gli ingredienti
	    if (savedPizza.getListaIngredienti() != null) {
	        for (Ingrediente ingrediente : savedPizza.getListaIngredienti()) {
	            if (ingrediente.getListaPizze() == null) {
	                ingrediente.setListaPizze(new LinkedList<>());
	            }
	            if (!ingrediente.getListaPizze().contains(savedPizza)) {
	                ingrediente.getListaPizze().add(savedPizza);
	                this.ingredienteService.save(ingrediente);  // salva lato owner
	            }
	        }
	    }

	    return savedPizza;
	}

}
