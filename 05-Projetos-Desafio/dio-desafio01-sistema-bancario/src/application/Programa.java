package application;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws InterruptedException, IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int itemMenu = 0;

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente("Lucas", 27, "H"));
        listaClientes.add(new Cliente("Fernanda", 26, "M"));
        listaClientes.add(new Cliente("Venilton", 38, "H"));
        listaClientes.add(new Cliente("Maria", 55, "M"));
        listaClientes.add(new Cliente("João", 18, "H"));

        List<ContaCorrente> listaCC = new ArrayList<>();
        List<ContaPoupanca> listaCP = new ArrayList<>();
        List<Conta> listaContas = new ArrayList<>();

        listaCC.add(new ContaCorrente(listaClientes.get(0)));
        listaCC.add(new ContaCorrente(listaClientes.get(1)));
        listaCP.add(new ContaPoupanca(listaClientes.get(2)));
        listaCC.add(new ContaCorrente(listaClientes.get(3)));
        listaCC.add(new ContaCorrente(listaClientes.get(4)));

        listaCC.get(0).depositar(100);
        listaCC.get(1).depositar(100);

        do {
            System.out.println("### Bem-Vindo(a) ao Banco BEST ###");
            acessarMenu();

            itemMenu = lerItemMenu(sc);

            if (!processarItemMenu(sc, itemMenu, listaClientes, listaCC, listaCP)) {
                System.out.print("Opção inválida. Tente novamente.");
                Thread.sleep(700);
                System.out.print(".");
                Thread.sleep(700);
                System.out.print(".");
                Thread.sleep(700);
                System.out.println();
            }
        } while (itemMenu != 7);
    }

    // ################################### FUNÇÕES ###################################

    private static int lerItemMenu(Scanner sc){
        System.out.print(">> Opção desejada: ");
        int itemEscolhido = sc.nextInt();
        sc.nextLine();
        return itemEscolhido;
    }

    public static void acessarMenu(){
        System.out.println("### MENU INICIAL ###");
        System.out.println("--------------------------");
        System.out.println("[1] - Abrir conta");
        System.out.println("[2] - Ver extrato");
        System.out.println("[3] - Depositar");
        System.out.println("[4] - Sacar");
        System.out.println("[5] - Transferir");
        System.out.println("[6] - Ver todos os clientes");
        System.out.println("[7] - Sair");
        System.out.println("--------------------------");
    }

    private static boolean processarItemMenu(Scanner sc, int itemMenu, List<Cliente> listaClientes,
                                             List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP)
            throws IOException, InterruptedException {

        switch(itemMenu){
            case 1:
                abrirConta(sc, listaClientes, listaCC, listaCP);
                return true;
            case 2:
                verExtrato(sc, listaCC, listaCP);
                return true;
            case 3:
                depositar(sc, listaCC, listaCP);
                return true;
            case 4:
                sacar(sc, listaCC, listaCP);
                return true;
            case 5:
                transferir(sc, listaCC, listaCP);
                return true;
            case 6:
                verClientes(listaClientes);
                return true;
            case 7:
                sairPrograma();
                return true;
            default:
            return false;
        }
    }

    public static void abrirConta(Scanner sc, List<Cliente> listaClientes, List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP) throws InterruptedException, IOException {
        int itemAbertura = 0;

        System.out.println("### ABERTURA DE CONTA ###");
        System.out.println("-----------------------------------------");

        do {
        System.out.println("[1] Conta Corrente | [2] Conta Poupança");
        System.out.print(">> Tipo de conta: ");
        int conta = sc.nextInt();

        if (conta == 1) {
            System.out.println("### Abertura de Conta Corrente ###");

            System.out.print(">> Nome do titular: ");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print(">> Idade do titular: ");
            int idade = sc.nextInt();
            System.out.print(">> Sexo do titular (H/M): ");
            String sexo = sc.next().toUpperCase();
            Cliente cliente = new Cliente(titular, idade, sexo);
            listaClientes.add(cliente);

            ContaCorrente cc = new ContaCorrente(cliente);
            listaCC.add(cc);
            System.out.println();
            System.out.println("Conta Corrente criada com sucesso!");
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println("[1] Ver outro extrado");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemAbertura = lerItemMenu(sc);
        }
        if (conta == 2) {
            System.out.println("### Abertura de Conta Poupança ###");

            System.out.print("Informe o nome do titular: ");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print("Informe a idade do titular: ");
            int idade = sc.nextInt();
            System.out.print("Informe o sexo do titular (H/M): ");
            String sexo = sc.next().toUpperCase();
            Cliente cliente = new Cliente(titular, idade, sexo);
            listaClientes.add(cliente);

            ContaPoupanca cp = new ContaPoupanca(cliente);
            listaCP.add(cp);
            System.out.println();
            System.out.println("Conta Poupança criada com sucesso!");
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println("[1] Ver outro extrado");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemAbertura = lerItemMenu(sc);
        }
        if (conta != 1 && conta !=2){
            System.out.println();
            System.out.println("Informação inválida. Tente novamente.");
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println("[1] Ver outro extrado");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemAbertura = lerItemMenu(sc);
        }
        } while (itemAbertura != 2);
    }

    public static void verExtrato(Scanner sc, List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP) {
        int itemExtrato = 0;

        System.out.println("### VER EXTRATO ###");
        System.out.println("-----------------------------------------");

        do {
            System.out.print(">> Número da conta: ");
            int contaNum = sc.nextInt();
            boolean achouCC = false;
            boolean achouCP = false;

            for (int i = 0; i < listaCC.size(); i++) {
                if (listaCC.get(i).getNumero() == contaNum) {
                    System.out.println();
                    listaCC.get(i).imprimirExtrato();
                    achouCC = true;
                }
            }
            if (achouCC == false) {
                for (int j = 0; j < listaCP.size(); j++) {
                    if (listaCP.get(j).getNumero() == contaNum) {
                        System.out.println();
                        listaCP.get(j).imprimirExtrato();
                        achouCP = true;
                    }
                }
            }
            if (achouCP == false && achouCC == false) {
                System.out.println();
                System.out.println("Conta não encontrada!");
                System.out.println();
            }

            System.out.println("-----------------------------------------");
            System.out.println("[1] Ver outro extrado");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemExtrato = lerItemMenu(sc);

        } while (itemExtrato != 2);
    }

    public static void depositar(Scanner sc, List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP) {
        int itemDeposito = 0;
        String valorDeposito = "0";

        System.out.println("### DEPÓSITO BANCÁRIO ###");
        System.out.println("-----------------------------------------");

        do {
        System.out.print(">> Número da conta de deposito: ");
        int contaNum = sc.nextInt();
        sc.nextLine();

        boolean achouCC = false;
        boolean achouCP = false;

        for (int i = 0; i < listaCC.size(); i++) {
            if (listaCC.get(i).getNumero() == contaNum) {
                System.out.println();
                System.out.println("A conta informada foi: ");
                listaCC.get(i).infoConta();
                achouCC = true;
                if (achouCC == true) {
                    System.out.println("A conta está correta? (S/N)");
                    String contaCorreta = sc.next().toUpperCase().trim();
                    if (contaCorreta.toUpperCase().equals("S")){
                        System.out.print(">> Valor de deposito: ");
                        valorDeposito = sc.next();
                        listaCC.get(i).depositar(Double.parseDouble(valorDeposito.replace(",", ".")));
                        System.out.println("Deposito realizado com sucesso!");
                        System.out.println();
                    } else {
                        System.out.println("Deposito não confirmado.");
                        System.out.println();
                    }
                }
            }
        }
        if (achouCC == false) {
            for (int j = 0; j < listaCP.size(); j++) {
                if (listaCP.get(j).getNumero() == contaNum) {
                    System.out.println();
                    System.out.println("A conta informada foi: ");
                    listaCP.get(j).infoConta();
                    achouCP = true;
                    if (achouCP == true) {
                        System.out.println("A conta está correta? (S/N)");
                        String contaCorreta = sc.next().toUpperCase().trim();
                        if (contaCorreta.toUpperCase().equals("S")){
                            System.out.print(">> Valor de deposito: ");
                            valorDeposito = sc.next();
                            listaCP.get(j).depositar(Double.parseDouble(valorDeposito.replace(",", ".")));
                            System.out.println("Deposito realizado com sucesso!");
                            System.out.println();
                        } else {
                            System.out.println("Deposito não confirmado.");
                            System.out.println();
                        }
                    }
                }
            }
        }
        if (achouCP == false && achouCC == false) {
            System.out.println();
            System.out.println("Conta não encontrada!");
            System.out.println();
        }
            System.out.println("-----------------------------------------");
            System.out.println("[1] Fazer outro deposito");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemDeposito = lerItemMenu(sc);

        } while (itemDeposito != 2);
    }

    public static void sacar(Scanner sc, List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP) {
        int itemSaque = 0;
        String valorSaque = "0";

        System.out.println("### SAQUE BANCÁRIO ###");
        System.out.println("-----------------------------------------");

        do {
            System.out.print(">> Número da conta de saque: ");
            int contaNum = sc.nextInt();
            sc.nextLine();

            boolean achouCC = false;
            boolean achouCP = false;

            for (int i = 0; i < listaCC.size(); i++) {
                if (listaCC.get(i).getNumero() == contaNum) {
                    System.out.println();
                    System.out.println("A conta informada foi: ");
                    listaCC.get(i).infoConta();
                    achouCC = true;
                    if (achouCC == true) {
                        System.out.println("A conta está correta? (S/N)");
                        String contaCorreta = sc.next().toUpperCase().trim();
                        if (contaCorreta.toUpperCase().equals("S")){
                            System.out.print(">> Valor de saque: ");
                            valorSaque = sc.next();
                            listaCC.get(i).sacar(Double.parseDouble(valorSaque.replace(",", ".")));
                            System.out.println("Saque realizado com sucesso!");
                            System.out.println();
                        } else {
                            System.out.println("Saque não confirmado.");
                            System.out.println();
                        }
                    }
                }
            }
            if (achouCC == false) {
                for (int j = 0; j < listaCP.size(); j++) {
                    if (listaCP.get(j).getNumero() == contaNum) {
                        System.out.println();
                        System.out.println("A conta informada foi: ");
                        listaCP.get(j).infoConta();
                        achouCP = true;
                        if (achouCP == true) {
                            System.out.println("A conta está correta? (S/N)");
                            String contaCorreta = sc.next().toUpperCase().trim();
                            if (contaCorreta.toUpperCase().equals("S")){
                                System.out.print(">> Valor de saque: ");
                                valorSaque = sc.next();
                                listaCP.get(j).sacar(Double.parseDouble(valorSaque.replace(",", ".")));
                                System.out.println("Saque realizado com sucesso!");
                                System.out.println();
                            } else {
                                System.out.println("Saque não confirmado.");
                                System.out.println();
                            }
                        }
                    }
                }
            }
            if (achouCP == false && achouCC == false) {
                System.out.println();
                System.out.println("Conta não encontrada!");
                System.out.println();
            }
            System.out.println("-----------------------------------------");
            System.out.println("[1] Fazer outro saque");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemSaque = lerItemMenu(sc);

        } while (itemSaque != 2);
    }

    public static void transferir(Scanner sc, List<ContaCorrente> listaCC, List<ContaPoupanca> listaCP) {
        int itemTransf = 0;
        String valorTransf = "0";

        System.out.println("### TRANSFERÊNCIA BANCÁRIA ###");
        System.out.println("-----------------------------------------");

        do {
            System.out.print(">> Número da conta de ORIGEM: ");
            int contaOrigemNum = sc.nextInt();
            sc.nextLine();

            boolean achouCCOrigem = false;
            boolean achouCPOrigem = false;
            boolean achouCCDestino = false;
            boolean achouCPDestino = false;

            int iCCOrigem = 0;
            int iCPOrigem = 0;
            int iCCDestino = 0;
            int iCPDestino = 0;

            for (int i = 0; i < listaCC.size(); i++) {
                if (listaCC.get(i).getNumero() == contaOrigemNum) {
                    System.out.println();
                    System.out.println("A conta de origem é: ");
                    listaCC.get(i).infoConta();
                    achouCCOrigem = true;
                    if (achouCCOrigem == true) {
                        System.out.println("A conta está correta? (S/N)");
                        String contaCorreta = sc.next().toUpperCase().trim();
                        if (contaCorreta.toUpperCase().equals("S")){
                            iCCOrigem = i;
                        } else {
                            System.out.println("Transferência não confirmada.");
                            System.out.println();
                        }
                    }
                }
            }
            if (achouCCOrigem == false) {
                for (int j = 0; j < listaCP.size(); j++) {
                    if (listaCP.get(j).getNumero() == contaOrigemNum) {
                        System.out.println();
                        System.out.println("A conta informada foi: ");
                        listaCP.get(j).infoConta();
                        achouCPOrigem = true;
                        if (achouCPOrigem == true) {
                            System.out.println("A conta está correta? (S/N)");
                            String contaCorreta = sc.next().toUpperCase().trim();
                            if (contaCorreta.toUpperCase().equals("S")){
                                iCPOrigem = j;
                            } else {
                                System.out.println("Saque não confirmado.");
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.print(">> Número da conta de DESTINO: ");
            int contaDestinoNum = sc.nextInt();
            sc.nextLine();


            for (int i = 0; i < listaCC.size(); i++) {
                if (listaCC.get(i).getNumero() == contaDestinoNum) {
                    System.out.println();
                    System.out.println("A conta de DESTINO é: ");
                    listaCC.get(i).infoConta();
                    achouCCDestino = true;
                    if (achouCCDestino == true) {
                        System.out.println("A conta está correta? (S/N)");
                        String contaCorreta = sc.next().toUpperCase().trim();
                        if (contaCorreta.toUpperCase().equals("S")){
                            iCCDestino = i;
                        } else {
                            System.out.println("Transferência não confirmada.");
                            System.out.println();
                        }
                    }
                }
            }
            if (achouCCDestino == false) {
                for (int j = 0; j < listaCP.size(); j++) {
                    if (listaCP.get(j).getNumero() == contaDestinoNum) {
                        System.out.println();
                        System.out.println("A conta informada foi: ");
                        listaCP.get(j).infoConta();
                        achouCPDestino = true;
                        if (achouCPDestino == true) {
                            System.out.println("A conta está correta? (S/N)");
                            String contaCorreta = sc.next().toUpperCase().trim();
                            if (contaCorreta.toUpperCase().equals("S")){
                                iCPDestino = j;
                            } else {
                                System.out.println("Saque não confirmado.");
                                System.out.println();
                            }
                        }
                    }
                }
            }
            if (achouCCOrigem == true || achouCPOrigem == true && achouCCDestino == true || achouCPDestino == true){
                System.out.print(">> Valor da transferência: ");
                valorTransf = sc.next();
                if (achouCCOrigem == true && achouCCDestino == true){
                    listaCC.get(iCCOrigem).transferir(Double.parseDouble(valorTransf.replace(",", "."))
                            , listaCC.get(iCCDestino));
                    System.out.println("Transferência realizada com sucesso!");
                }
                if (achouCCOrigem == true && achouCPDestino == true){
                    listaCC.get(iCCOrigem).transferir(Double.parseDouble(valorTransf.replace(",", "."))
                            , listaCP.get(iCPDestino));
                    System.out.println("Transferência realizada com sucesso!");
                }
                if (achouCPOrigem == true && achouCCDestino == true){
                    listaCP.get(iCPOrigem).transferir(Double.parseDouble(valorTransf.replace(",", "."))
                            , listaCC.get(iCCDestino));
                    System.out.println("Transferência realizada com sucesso!");
                }
                if (achouCPOrigem == true && achouCPDestino == true){
                    listaCP.get(iCPOrigem).transferir(Double.parseDouble(valorTransf.replace(",", "."))
                            , listaCP.get(iCPDestino));
                    System.out.println("Transferência realizada com sucesso!");
                }
            }

            if (achouCCOrigem == false && achouCPOrigem == false ) {
                System.out.println();
                System.out.println("Conta de ORIGEM não encontrada!");
                System.out.println();
            }
            if (achouCCDestino == false && achouCPDestino == false) {
                System.out.println();
                System.out.println("Conta de DESTINO não encontrada!");
                System.out.println();
            }
            System.out.println("-----------------------------------------");
            System.out.println("[1] Fazer outra transferência");
            System.out.println("[2] Menu Principal ");
            System.out.println("-----------------------------------------");
            itemTransf = lerItemMenu(sc);

        } while (itemTransf != 2);

    }

    private static void verClientes(List<Cliente> listaClientes) throws IOException {
        System.out.println("### LISTA DE CLIENTES ###");
        System.out.println("-----------------------------------------");
        System.out.format("%6s | %-15s | %5s | %5s%n", "Código", "Nome", "Idade", "Sexo");
        int indexCliente = 0;
        for (Cliente chave : listaClientes){
            System.out.format("%6s | %-15s | %5s | %5s%n", "["+indexCliente+"]", chave.getNome(), chave.getIdade(), chave.getSexo());
            indexCliente++;
        }
        System.out.println("-----------------------------------------");
        System.out.println(">> Pressione ENTER para voltar ao menu...");
        System.in.read();
    }

    public static void sairPrograma() throws InterruptedException {
        System.out.print("Saindo do programa.");
        Thread.sleep(700);
        System.out.print(".");
        Thread.sleep(700);
        System.out.print(".");
        Thread.sleep(700);
    }
}
