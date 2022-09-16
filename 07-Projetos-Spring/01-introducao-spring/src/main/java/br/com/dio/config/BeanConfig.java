package br.com.dio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

	
	@Bean
	@Scope("prototype")
	public BeanTeste beanTeste() {
		return new BeanTeste();
	}
}
