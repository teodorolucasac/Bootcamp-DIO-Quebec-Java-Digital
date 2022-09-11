package br.com.dio.collection.map;

import java.util.*;

public class Exercicio02LancamentoDados {
    public static void main(String[] args) {

        List<Integer> valores = new ArrayList<>();
        Random gerador = new Random();
        int quantidade = 100;

        for (int i=0; i<quantidade; i++){
            int numero = gerador.nextInt(6)+1;
            valores.add(numero);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores){
            if (lancamentos.containsKey(resultado)){
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            } else {
                lancamentos.put(resultado, 1);
            }
        }

        System.out.print("Jogando");
        for (int i=0; i < 3; i++){
            try{
                System.out.print(".");
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor "+" Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}
