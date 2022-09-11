package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio01TemperaturaMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> temperature = new ArrayList<>();

        //Recebendo por scanner a temperatura dos 6 meses
        double sum = 0;
        for (int i=1; i <= 6; i++) {
            System.out.print("Digite a temperatura do mês "+i+": ");
            Double temp = sc.nextDouble();
            temperature.add(temp);

            sum += temp;
        }
        System.out.println("-------------------");

        //Exibindo todas as temperaturas por foreach com expressão lambda
        System.out.print("Todas as temperaturas: ");
        temperature.forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println("-------------------");

        //Calculando a média através da variável sum dividido pelo tamanho da list
        double middleTemp = sum / temperature.size();
        System.out.println("A média da temperatura semestral é: "+middleTemp);
        System.out.println("-------------------");

        //Foreach para percorrer, condição de temp maior que média com if,
        // e condição para exibir os meses com switch case
        for (Double temp : temperature){
            if (temp > middleTemp){
                int index = temperature.indexOf(temp);
                switch (index) {
                    case 0:
                        System.out.println("Jan: "+temp+" oC");
                        break;
                    case 1:
                        System.out.println("Feb: "+temp+" oC");
                        break;
                    case 2:
                        System.out.println("Mar: "+temp+" oC");
                        break;
                    case 3:
                        System.out.println("Apr: "+temp+" oC");
                        break;
                    case 4:
                        System.out.println("May: "+temp+" oC");
                        break;
                    case 5:
                        System.out.println("Jun: "+temp+" oC");
                        break;
                    default:
                        break;
                }
            }
        }



    }
}
