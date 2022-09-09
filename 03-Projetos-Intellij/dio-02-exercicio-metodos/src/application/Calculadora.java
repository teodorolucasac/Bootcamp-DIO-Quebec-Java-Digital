package application;

import java.util.Scanner;

public class Calculadora {

    public static void somar(int a, int b){
        int resultado = a + b;

        System.out.println(a+" + "+b+" = "+resultado);
    }
    public static void subtrair(double a, double b){
        double resultado = a - b;

        System.out.println(a+" - "+b+" = "+resultado);
    }
    public static void multiplicar(int a, int b){
        int resultado = a * b;

        System.out.println(a+" * "+b+" = "+resultado);
    }
    public static void dividir(double a, double b){
        double resultado = a / b;

        System.out.println(a+" / "+b+" = "+resultado);
    }
}
