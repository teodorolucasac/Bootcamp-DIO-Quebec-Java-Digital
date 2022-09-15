package entities;


public abstract class Conta {
    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL_CONTA = 0;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL_CONTA++;
        this.cliente = cliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() { return numero; }

    public Double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void infoConta() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.println();
    }


}
