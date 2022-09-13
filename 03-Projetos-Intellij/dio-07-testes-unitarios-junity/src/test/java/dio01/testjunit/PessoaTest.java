package dio01.testjunit;

import dio01.junit.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class PessoaTest {

    @Test
    void validarCalculoDeIdade() {
        Pessoa julia = new Pessoa("Julia", LocalDateTime.of(2020, 1, 1, 15, 00));
        Assertions.assertEquals(2, julia.getIdade());

    }

    @Test
    void deveCalcularIdadeCorretamente(){
        Pessoa jessica = new Pessoa("Jéssica", LocalDateTime.of(2000, 1, 1, 10,00));
        Assertions.assertEquals(22, jessica.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade() {
        Pessoa lucas = new Pessoa("Lucas", LocalDateTime.of(1994,10,14,7,30));
        Assertions.assertTrue(lucas.ehMaiorDeIdade());

        Pessoa joao = new Pessoa("João", LocalDateTime.now());
        Assertions.assertFalse(joao.ehMaiorDeIdade());
    }
}
