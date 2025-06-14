package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {
	
	@Autowired
	RecensioneRepository recensioneRepository;
	
	public Recensione getRecensioneById(Long id) {
		return recensioneRepository.findById(id).get();		
	}
	
	public Iterable<Recensione> getAllRecensioni(){
		return recensioneRepository.findAll();
	}
	
	
	public List<Recensione> getByAutore(Credentials autore) {
	    return recensioneRepository.findByAutore(autore);
	}
	
	public Recensione save(Recensione recensione) {
		return recensioneRepository.save(recensione);
	}

	public void deleteById(Long id) {
		recensioneRepository.deleteById(id);
	}
}
