package br.com.dio.collection.streamapi;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {

        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

//        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set.");
        // Colocando dentro de uma variável:
        Set<String> collectSet = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());
        //Imprimindo sem usar variável:
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Transforme essa lista em uma lista de números inteiros.");
        //numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList()).forEach(System.out::println);
        List<Integer> collectList = numerosAleatorios.stream().map(Integer::parseInt).toList();
        System.out.println(collectList);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista.");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream().map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);


        System.out.println("Mostre a média dos números.");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

        List<Integer> collectList2 = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Remova os valores ímpares.");
        collectList2.removeIf(i -> (i % 2 != 0));
        System.out.println(collectList2);


        // PRA VOCÊ
        System.out.println("Ignore os 3 primeiros itens da lista e imprima o restante");
        numerosAleatorios.stream().skip(3).forEach(System.out::println);

        System.out.println("Retirando os números repetidos da lista, quantos ficam?");
        long countNumerosUnicos = collectList.stream().distinct().count();
        System.out.println(countNumerosUnicos);

        System.out.println("Mostre o menor valor da lista: ");
        collectList.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista: ");
        collectList.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);


        System.out.println("Pegue os números ímpares e some.");
        int somaImpares = collectList.stream()
                .filter(i -> (i % 2 != 0)).mapToInt(Integer::intValue).sum();
        System.out.println(somaImpares);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = collectList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = collectList.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);

    }
}
