package br.com.dio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entities.User;
import br.com.dio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<String> buscaDadosBanco() {
		List<String> nomes = new ArrayList<>();
			System.out.println("Chamou o metodo de busca");
			return nomes;
	}
	
	public void deletaDados() {
		System.out.println("Chamou o delete");
	}

	public User buscaUsuarioId(long id) {
		User user = new User();
		user.setNome("Kaique");
		
		userRepository.save(user);
		
		return userRepository.findById(id).get();
	}
}
