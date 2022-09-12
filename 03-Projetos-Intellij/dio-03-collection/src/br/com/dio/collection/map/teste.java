package br.com.dio.collection.map;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int t = leitor.nextInt();

// TODO: Implemente uma condição onde possamos preencher o vetor de N.
// Lembre-se a sequência de valores é de 0 até T-1:
        int[] n = new int[1000];

        for(int i=0; i < n.length; i=i ){
            for(int j=0; j< t; j++){
                if(i < n.length){
                    Arrays.fill(n, j);
                    System.out.println("N[" + i + "] = "+ n[i]);
                    i++;
                }
            }
        }
    }
    }
