package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialsRepository;
import jakarta.transaction.Transactional;

@Service
public class CredentialsService {

	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Autowired
	protected CredentialsRepository credentialsRepository;
	
	@Transactional
	public Credentials getCredentials(Long id) {
		return this.credentialsRepository.findById(id).get();
	}
	
	@Transactional
	public Credentials getCredentials(String username) {
		return this.credentialsRepository.findByUsername(username).orElse(null);
	}
	
	@Transactional
	public Credentials saveCredentials(Credentials credentials) {
		credentials.setRuolo(Credentials.DEFAULT_ROLE);
		credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
		return this.credentialsRepository.save(credentials);
	}
}
