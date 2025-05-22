package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente getPizzabyId(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	public Iterable<Ingrediente> getAllPizzas() {
		return ingredienteRepository.findAll();
	}
}
