package dio01.testjunit;

import dio01.junit.BancoDeDados;
import dio01.junit.Pessoa;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class ConsultarDadosDePessoaTest {
    @BeforeAll
    static void configuraConexao(){
        BancoDeDados.iniciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste() {
        BancoDeDados.insereDados(new Pessoa("João", LocalDateTime.of(2000,1,1,13,00)));
    }

    @AfterEach
    void removeDadosParaTeste() {
        BancoDeDados.removeDados(new Pessoa("João", LocalDateTime.of(2000,1,1,13,00)));
    }

    @Test
    void validarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }

    @Test
    void validarDadosDeRetorno2(){
        Assertions.assertNull(null);
    }

    @AfterAll
    static void finalizarConexao(){
        BancoDeDados.finalizarConexao();
    }
}
