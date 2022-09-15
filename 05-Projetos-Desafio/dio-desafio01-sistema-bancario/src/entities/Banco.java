package entities;


import java.util.List;
import java.util.Scanner;

public class Banco {
    Scanner sc = new Scanner(System.in);
    public String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
