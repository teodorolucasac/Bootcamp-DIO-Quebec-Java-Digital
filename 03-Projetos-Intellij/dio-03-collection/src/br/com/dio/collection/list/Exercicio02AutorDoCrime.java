package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio02AutorDoCrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> respostasList = new ArrayList<>();

        System.out.println("------ INTERROGATÓRIO ------");
        System.out.println();

        System.out.print("Telefonou para a vítima? (S/N) ");
        String resposta = sc.next();
        respostasList.add(resposta.toLowerCase());

        System.out.print("Esteve no local do crime? (S/N) ");
        resposta = sc.next();
        respostasList.add(resposta.toLowerCase());

        System.out.print("Mora perto da vítima? (S/N) ");
        resposta = sc.next();
        respostasList.add(resposta.toLowerCase());

        System.out.print("Devia para a vítima? (S/N) ");
        resposta = sc.next();
        respostasList.add(resposta.toLowerCase());

        System.out.print("Já trabalhou com a vítima? (S/N) ");
        resposta = sc.next();
        respostasList.add(resposta.toLowerCase());
        System.out.println("---------------");

        // 1ª FORMA DE CONTAR RESPOSTAS
        int count = 0;
        for(String resp : respostasList){
            if (resp.contains("s")) {
                count++;
            }
        }

        /*
        // 2ª FORMA DE CONTAR RESPOSTAS
        int count = 0;
        Iterator<String> contador = respostas.iterator();
        while(contador.hasNext()){
            String resp = contador.next();
            if(resp.contains("s")) {
                count ++;
            }
        }
         */

        // 1ª FORMA DE VERIFICAR GRAU DE SUSPEITA
        if (count < 2){
            System.out.println("Você é INOCENTE!");
        } else if (count == 2){
            System.out.println("Você é SUSPEITO!");
        } else if (count <= 4) {
            System.out.println("Você é CÚMPLICE!");
        } else {
            System.out.println("Você é ASSASSINO!");
        }


        /*
        // 2ª FORMA DE VERIFICAR GRAU DE SUSPEITA
         switch(count) {
            case 2:
                System.out.println(">> SUSPEITO <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<"); break;
            case 5:
                System.out.println(">> ASSASSINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
        */
    }
}
