package dio01.testjunit;

import dio01.junit.Conta;
import dio01.junit.TransferenciaEntreContas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTeste {

    @Test
    void validarCenarioDeExcecaoNaTransferencia() {
        Conta contaOrigem = new Conta("12345", 0);
        Conta contaDestino = new Conta("56789", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                transferenciaEntreContas.transfere(contaOrigem, contaDestino, -1));
    }

    @Test
    void validarCenarioDeExcecaoNaTransferencia2() {
        Conta contaOrigem = new Conta("12345", 0);
        Conta contaDestino = new Conta("56789", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        Assertions.assertDoesNotThrow(() ->
                transferenciaEntreContas.transfere(contaOrigem, contaDestino, 10));
    }
}
