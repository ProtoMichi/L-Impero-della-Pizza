package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Pizza;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;

public interface RecensioneRepository extends CrudRepository<Recensione, Long>{
	public List<Recensione> findByAutore(Credentials autore);
	public boolean existsByPizzaAndAutore(Pizza pizza, Credentials autore);
}