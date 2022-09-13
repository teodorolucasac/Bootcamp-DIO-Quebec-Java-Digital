package dio01.testjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTeste {

    @Test
    void validarAlgoSomenteNoUsuarioLucas() {
        Assumptions.assumeTrue("lukas".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5+5);
    }
}
