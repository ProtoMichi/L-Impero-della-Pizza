package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
}
