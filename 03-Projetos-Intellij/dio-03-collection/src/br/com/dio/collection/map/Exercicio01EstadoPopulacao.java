package br.com.dio.collection.map;

import java.util.*;

import static java.util.Locale.*;

public class Exercicio01EstadoPopulacao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Map<String, Integer> estadoPopulacao = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println("--\tRelacione os estados e suas populações\t--");
        System.out.println(estadoPopulacao.toString());

        System.out.println("--\tSubstitua a população do RN por 3.534.165\t--");
        estadoPopulacao.put("RN", 3534165);
        System.out.println(estadoPopulacao);

        System.out.println("--\tConfira se o estado PB está no dicionario, caso não adicione: PB - 4.039.277\t--");
        System.out.println("O Map possui PB? "+estadoPopulacao.containsKey("PB"));
        estadoPopulacao.put("PB", 4039277);
        System.out.println(estadoPopulacao);
        System.out.println("O Map possui PB? "+estadoPopulacao.containsKey("PB"));

        System.out.println("--\tExiba a população de PE\t--");
        System.out.println("População de PE: "+estadoPopulacao.get("PE"));

        System.out.println("--\tExiba todos os estados e suas populações na ordem informada\t--");
        Map<String, Integer> estadoPopulacao1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadoPopulacao1);

        System.out.println("--\tExiba todos os estados em ordem alfabética\t--");
        Map<String, Integer> estadoPopulacao2 = new TreeMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadoPopulacao2);

        System.out.println("--\tExiba o estado com menor população e sua quantidade\t--");
        Integer menorPopulacao = Collections.min(estadoPopulacao.values());

        String menorEstado = "";
        Set<Map.Entry<String, Integer>> entries = estadoPopulacao.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            if (entry.getValue().equals(menorPopulacao)){
                menorEstado = entry.getKey();
                System.out.println("Estado com menor população: "+menorEstado+" - "+menorPopulacao);
            }
        }


        System.out.println("--\tExiba o estado com maior população e sua quantidade\t--");
        Integer maiorPopulacao = Collections.max(estadoPopulacao.values());

        String maiorEstado = "";
        Set<Map.Entry<String, Integer>> entries1 = estadoPopulacao.entrySet();
        for (Map.Entry<String, Integer> entry : entries1){
            if (entry.getValue().equals(maiorPopulacao)){
                maiorEstado = entry.getKey();
                System.out.println("Estado com maior população: "+maiorEstado+" - "+maiorPopulacao);
            }
        }


        System.out.println("--\tExiba a soma da população dos estados\t--");
        Integer soma = 0;
        Iterator<Integer> iterator = estadoPopulacao1.values().iterator();
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma dos estados: "+ soma);


        System.out.println("--\tExiba a media da população dos estados\t--");
        System.out.println("Média: " + soma / estadoPopulacao1.size());


        System.out.println("--\tRemova os estados com a população menor que 4.000.000\t--");
        Iterator<Integer> iterator1 = estadoPopulacao1.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next() < 4000000) {
                iterator1.remove();
            }
        }
        System.out.println(estadoPopulacao1);

        System.out.println("--\tApague o dicionário de estados\t--");
        estadoPopulacao.clear();
        System.out.println(estadoPopulacao);

        System.out.println("--\tConfira se o dicionário está vazio\t--");
        System.out.println("Dicionário 1 vazio? "+ estadoPopulacao.isEmpty());
        System.out.println("Dicionário 2 vazio? "+ estadoPopulacao1.isEmpty());

    }
}
