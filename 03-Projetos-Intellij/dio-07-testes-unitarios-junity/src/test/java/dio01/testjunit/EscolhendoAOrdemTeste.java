package dio01.testjunit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class EscolhendoAOrdemTeste {

    @DisplayName("D")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    @DisplayName("C")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    @DisplayName("B")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    @DisplayName("A")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}
