package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //Calculadora
        System.out.println("Exercício calculadora: ");
        Calculadora.somar(3, 6);
        Calculadora.subtrair(9, 1.8);
        Calculadora.multiplicar(7, 8);
        Calculadora.dividir(5, 2);
        System.out.println();

        //Mensagem
        System.out.println("Exercício mensagem");
        Mensagem.obterMensagem(9);
        Mensagem.obterMensagem(14);
        Mensagem.obterMensagem(1);
        System.out.println();

        //Empréstimo
        System.out.println("Exercício empréstimo");
        Emprestimo.calcular(1000, Emprestimo.getDuasParcelas());
        Emprestimo.calcular(1000, Emprestimo.getTresParcelas());
        Emprestimo.calcular(1000, 3);
        Emprestimo.calcular(1000, 5);
        System.out.println();

        //Quadrilátero
        System.out.println("Exercício Quadrilátero");
        Quadrilatero.area(3);
        Quadrilatero.area(5d, 5d);
        Quadrilatero.area(7, 8, 9);
        Quadrilatero.area(5f, 5f);
        System.out.println();

        //Quadrilátero
        System.out.println("Exercício Quadrilátero com Retorno");

        double areaQuadrado = QuadrilateroReturn.area(3);
        System.out.println("Área do Quadrado: " + areaQuadrado);

        double areaRetangulo = QuadrilateroReturn.area(5d, 5d);
        System.out.println("Área do Retângulo: " + areaRetangulo);

        double areaTrapezio = QuadrilateroReturn.area(7, 8, 9);
        System.out.println("Área do Trapézio: " + areaTrapezio);
    }
}

