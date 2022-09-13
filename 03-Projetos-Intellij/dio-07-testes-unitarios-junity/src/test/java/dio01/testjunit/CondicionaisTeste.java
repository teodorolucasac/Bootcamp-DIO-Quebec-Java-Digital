package dio01.testjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class CondicionaisTeste {

    @Test
    @EnabledIfEnvironmentVariable(named="USER", matches = "lukas")
    void validarAlgoSomenteNoUsuarioLucas() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @DisabledIfEnvironmentVariable(named="USER", matches = "root")
    void devalidarAlgoSomenteNoUsuarioRoot() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void executarSomenteNoSistemaWindows() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
    void executarSomenteNosSistemasDoArray() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_18)
    void executarSomenteNaJreJava18() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_14)
    void executarSomenteNaJre11a14() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
