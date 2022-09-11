package br.com.dio.collection.set;

import java.util.*;

public class Exercicio01ArcoIris {
    public static void main(String[] args) {

        Set<String> coresArcoIris = new HashSet<>(Arrays.asList(
                "vermelha", "laranja", "amarela", "verde", "azul", "anil", "violeta"));

        System.out.println("---- Exiba todas as cores uma abaixo da outra ----");
        Iterator<String> iterador = coresArcoIris.iterator();
        while (iterador.hasNext()) {
            String exibir = iterador.next();
            System.out.println(exibir);
        }
        System.out.println();

        System.out.println("---- Exiba a quantidade de cores do Arco-Íris ----");
        System.out.println(coresArcoIris.size());
        System.out.println();

        System.out.println("---- Exiba as cores em ordem alfabética ----");
        Set<String> coresArcoIris1 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris1);
        System.out.println();

        System.out.println("---- Exiba as cores em ordem inversa da que foi informada ----");
        //Descidi não criar um LinkedHashSet com uma ordem porque o exercício já funciona com a ordem alfabética do TreeSet
//        Set<String> coresArcoIris2 = new LinkedHashSet<>(Arrays.asList(
//                "vermelha", "laranja", "amarela", "verde", "azul", "anil", "violeta"));
//        System.out.println(coresArcoIris2);
        List<String> coresReverse = new ArrayList<>(coresArcoIris1);
        Collections.reverse(coresReverse);
        System.out.println(coresReverse);
        System.out.println();


        System.out.println("---- Exiba todas as cores que começam com a letra V ----");
        for(String y : coresArcoIris1){
            if (y.startsWith("v")) {
                System.out.println(y);
            }
        }
        System.out.println();

        System.out.println("---- Remova todas as cores que não começam com a letra V ----");
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while (iterator2.hasNext()){
            if(!iterator2.next().startsWith("v")){
            iterator2.remove();
            }
        }
        System.out.println(coresArcoIris);
        System.out.println();

        System.out.println("---- Limpe o conjunto e confirme se está vázio ----");
        coresArcoIris.clear();
        System.out.println("Conjunto 0: "+coresArcoIris.isEmpty());
        System.out.println("Conjunto 1: "+coresArcoIris1.isEmpty());


    }
}
