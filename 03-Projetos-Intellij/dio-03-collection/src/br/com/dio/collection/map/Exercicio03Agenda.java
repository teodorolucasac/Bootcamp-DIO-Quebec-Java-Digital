package br.com.dio.collection.map;

import java.util.*;

public class Exercicio03Agenda {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Exercicio03Contato> agenda = new HashMap<>() {{
            put(1, new Exercicio03Contato("Simba", 5555));
            put(4, new Exercicio03Contato("Cami", 1111));
            put(3, new Exercicio03Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Exercicio03Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Exercicio03Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Exercicio03Contato("Simba", 5555));
            put(4, new Exercicio03Contato("Cami", 1111));
            put(3, new Exercicio03Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Exercicio03Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Exercicio03Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer, Exercicio03Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        //precisamos organizar os valores. Logo:

        // CLASSE ANONIMA
        /*
        Set<Map.Entry<Integer, Exercicio03Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Exercicio03Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Exercicio03Contato> cont1, Map.Entry<Integer, Exercicio03Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });
         */

        // FUNCTIONAL INTERFACE
        /*
        Set<Map.Entry<Integer, Exercicio03Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Exercicio03Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Exercicio03Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));
         */

        // LAMBDA
        Set<Map.Entry<Integer, Exercicio03Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));


        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Exercicio03Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " +entry.getValue().getNome());
        }

        System.out.println("--\tOrdem nome Exercicio03Contato\t--");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Exercicio03Contato>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Exercicio03Contato> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}

/*
class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Exercicio03Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Exercicio03Contato> cont1, Map.Entry<Integer, Exercicio03Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}

 */


class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Exercicio03Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Exercicio03Contato> cont1, Map.Entry<Integer, Exercicio03Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}
