package desafios;

import java.util.Scanner;

public class Desafio01 {
    public static void main(String[] args) {

// Retorne quantos passos deve acontecer para zerar um valor informando
// Sendo certo que, ser for par devemos dividir por 2, se for impar subtrair 1

        int num = Integer.parseInt(new Scanner(System.in).nextLine());
        var step = 0;

// TODO: Implemente uma condição onde seja possível reduzir o número até 0:

        while (num > 0) {
            if (num % 2 != 0) {
                num -= 1;
                step++;
            } else {
                num /= 2;
                step++;
            }
        }

        System.out.println(step);
    }
}
