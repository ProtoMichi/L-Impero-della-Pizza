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
	
	
	public Iterable<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
	}

	
	public Pizza save(Pizza pizza) {
	    return this.pizzaRepository.save(pizza);
	}
	
	public void deleteById(Long id) {
		this.pizzaRepository.deleteById(id);
	}

}
