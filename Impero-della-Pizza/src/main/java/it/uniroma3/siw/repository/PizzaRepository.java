package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

	@Query("SELECT p FROM Pizza p LEFT JOIN FETCH p.listaIngredienti WHERE p.id = :id")
    public Pizza findByIdFetchIngredienti(@Param("id") Long id);
}
