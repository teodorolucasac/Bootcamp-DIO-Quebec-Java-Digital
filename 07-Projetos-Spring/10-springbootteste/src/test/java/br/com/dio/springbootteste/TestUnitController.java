package br.com.dio.springbootteste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.dio.springbootteste.controller.TesteController;

public class TestUnitController {
	
	@Test
	public void testUnit() {
		TesteController controller = new TesteController();
		String resultado  = controller.saudacao("DIO");
		assertEquals("Bem-vindo, DIO", resultado);
	}

}
