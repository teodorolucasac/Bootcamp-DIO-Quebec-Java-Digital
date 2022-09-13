package dio01.junit;

public class Conta {

    private String numeroConta;
    private Integer saldo;

    public Conta(String numeroConta, Integer saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Integer getSaldo() {
        return saldo;
    }
}
