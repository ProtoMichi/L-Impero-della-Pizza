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
	
	public Ingrediente getIngredienteById(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	public List<Ingrediente> findAllById(Iterable<Long> ids) {
	    return (List<Ingrediente>) this.ingredienteRepository.findAllById(ids);
	}
	
	public Iterable<Ingrediente> getAllIngredienti() {
		return ingredienteRepository.findAll();
	}
	
	public List<Ingrediente> getAllIngredientiNotFarina(){
		return ingredienteRepository.findByNomeNotContaining("Farina");
	}
	
	public void save(Ingrediente ingrediente) {
		this.ingredienteRepository.save(ingrediente);
	}
}
