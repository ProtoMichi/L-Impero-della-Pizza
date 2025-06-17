package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

	public List<Pizza> findByListaIngredienti_NomeIgnoreCase(String ingrediente);
	
}
