package br.com.dio.collection.set;

import java.lang.reflect.Array;
import java.util.*;

public class Exercicio02LinguagemFavorita {
    public static void main(String[] args) {

        Set<LinguagemFavorita> linguagemList = new HashSet<>();
        linguagemList.add(new LinguagemFavorita("phyton", 2000, "springtoolsuite"));
        linguagemList.add(new LinguagemFavorita("kotlin", 1990, "eclipse"));
        linguagemList.add(new LinguagemFavorita("java", 1991, "vscode"));


        System.out.println("---- Ordene por Inserção ----");
        Set<LinguagemFavorita> linguagemList1 = new LinkedHashSet<>(Arrays.asList(
                new LinguagemFavorita("phyton", 2000, "springtoolsuite"),
                new LinguagemFavorita("kotlin", 1990, "eclipse"),
                new LinguagemFavorita("java", 1991, "vscode")
        ));
        for (LinguagemFavorita ling : linguagemList1){
        System.out.println(ling);
        }
        System.out.println();


        System.out.println("---- Ordene por Nome ----");
        Set<LinguagemFavorita> linguagemList2 = new TreeSet<>(linguagemList);
        for (LinguagemFavorita ling2 : linguagemList2){
            System.out.println(ling2);
        }
        System.out.println();

        System.out.println("---- Ordene por IDE ----");
        Set<LinguagemFavorita> linguagemList3 = new TreeSet<LinguagemFavorita>(new ComparatorIde());
        linguagemList3.addAll(linguagemList);
        for (LinguagemFavorita ling3 : linguagemList3){
            System.out.println(ling3);
        }
        System.out.println();

        System.out.println("---- Ordene por Ano e Nome ----");
        Set<LinguagemFavorita> linguagemList4 = new TreeSet<LinguagemFavorita>(new ComparatorAnoNome());
        linguagemList4.addAll(linguagemList);
        for (LinguagemFavorita ling4 : linguagemList4){
            System.out.println(ling4);
        }
        System.out.println();

        System.out.println("---- Ordene por Nome, Ano e IDE ----");
        Set<LinguagemFavorita> linguagemList5 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoIde());
        linguagemList5.addAll(linguagemList);
        for (LinguagemFavorita ling5 : linguagemList5){
            System.out.println(ling5);
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita() {
    }

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome) && anoDeCriacao.equals(that.anoDeCriacao) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return nome + " - " + anoDeCriacao + " - " + ide;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.nome.compareTo(linguagemFavorita.nome);
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        return lf1.getIde().compareToIgnoreCase(lf2.getIde());
    }
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        int ano = Integer.compare(lf1.getAnoDeCriacao(), lf2.getAnoDeCriacao());
        if (ano != 0 ){
            return ano;
        }
        return lf1.getNome().compareToIgnoreCase(lf2.getNome());
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {

        int nome = lf1.getNome().compareToIgnoreCase(lf2.getNome());
        if (nome != 0 )
            return nome;

        int ano = Integer.compare(lf1.getAnoDeCriacao(), lf2.getAnoDeCriacao());
        if (ano != 0 ){
            return ano;
        }

        return lf1.getIde().compareToIgnoreCase(lf2.getIde());
    }
}