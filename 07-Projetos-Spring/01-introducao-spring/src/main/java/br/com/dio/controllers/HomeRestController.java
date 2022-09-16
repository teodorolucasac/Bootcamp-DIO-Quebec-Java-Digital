package br.com.dio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.entities.User;
import br.com.dio.services.UserService;

@RestController
public class HomeRestController {
	
	@Autowired
	private UserService service;

	@RequestMapping("/rest")
	public User testeRest() {
		
		return service.buscaUsuarioId(1L);
	}
	
}
