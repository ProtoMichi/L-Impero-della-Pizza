package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	public Pizza getPizzabyId(Long id) {
		return pizzaRepository.findById(id).get();
	}
	
	public Iterable<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
	}

	public void save(Pizza pizza) {
		this.pizzaRepository.save(pizza);
	}
}
