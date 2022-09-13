package desafios;

import java.util.Scanner;

public class Desafio03 {
    public static void main(String[] args) {
        /*
        Desafio
Dado um inteiro positivo num, retorne o número de inteiros positivos menor ou igual a num cuja soma de dígitos é par.
A soma dos dígitos de um inteiro positivo é a soma de todos os seus dígitos.

Entrada
Como entrada você recerá um valor inteiro e positivo.

Saída
Como saída, será impresso a soma de todos os numeros inteiros positivos menores ou iguais ao num, como nos exemplos a baixo:
         */

        /*
        Entrada: 30
        Saida: 14
Explicação: Os inteiros menores ou iguais a 30 cujas somas de digitos sao pares são:
[2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26 e 28].
         */

        int num = Integer.parseInt(new Scanner(System.in).nextLine());
        var count = 0;
        int intPositivo = 0;

        for (int i = num; i > 0; i--) {
            intPositivo = i;
            for(int j = i; j > 0; j--){
                intPositivo += (j-1);
            }
            if (intPositivo % 2 == 0){
                count++;
            }
            intPositivo = 0;
        }
        System.out.println(count);

    }
}
