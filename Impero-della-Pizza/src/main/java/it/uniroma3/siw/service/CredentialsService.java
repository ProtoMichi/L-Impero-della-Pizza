package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialsRepository;
import jakarta.transaction.Transactional;

public class CredentialsService {

	private CredentialsRepository credentialsRepository;
	
	@Transactional
	public Credentials getCredentials(Long id) {
		return this.credentialsRepository.findById(id).get();
	}
	
	@Transactional
	public Credentials getCredentials(String username) {
		return this.credentialsRepository.findByUsername(username).get();
	}
	
	@Transactional
	public Credentials saveCredentials(Credentials credentials) {
		credentials.setRuolo(Credentials.DEFAULT_ROLE);
		return this.credentialsRepository.save(credentials);
	}
}
