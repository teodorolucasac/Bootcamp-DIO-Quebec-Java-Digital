import java.util.concurrent.ThreadLocalRandom;

public class ExemploWhile {
  public static void main(String[] args) {
    Double mesada = 50.0;

    while (mesada > 0){
      double valorDoce = valorAleatorio();
      if (valorDoce > mesada){
        valorDoce = mesada;
      }
      System.out.println("Doce do valor: "+ valorDoce + " Adicionado no carrinho");
      mesada -= valorDoce;
    }

    System.out.println("Joãozinho gastou toda a sua mesada em doces");
  }

  private static double valorAleatorio(){
    return ThreadLocalRandom.current().nextDouble(5,15);
  }
}
