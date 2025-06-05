package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente getIngredientebyId(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	public Iterable<Ingrediente> getAllIngredienti() {
		return ingredienteRepository.findAll();
	}
	
	public void save(Ingrediente ingrediente) {
		this.ingredienteRepository.save(ingrediente);
	}
	
	public List<Ingrediente> getFarine(){
		return ingredienteRepository.findByNomeStartingWith("Farina");
	}
}
