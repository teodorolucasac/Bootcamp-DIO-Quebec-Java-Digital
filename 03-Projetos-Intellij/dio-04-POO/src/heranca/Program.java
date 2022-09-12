package heranca;

public class Program {
    public static void main(String[] args) {

        // Estanciação normal, sem downcasting nem upcasting
        Funcionario funcionario = new Funcionario();

        // Upcasting (estou criando um Gerente com a classe Funcionário)
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();

        //Downcasting (estou criando um Funcionário com a classe Gerente)
        Gerente gerente2 = (Gerente) new Funcionario(); //downcasting explícito
        Vendedor vendedor2 = (Vendedor) new Funcionario(); //downcasting explícito
    }
}
