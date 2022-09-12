package POObasico;

public class Exercicio01POO {
    public static void main(String[] args) {

        Carro carro1 = new Carro("Honda", "New Civic", "Preto", 5, 59);

        System.out.println(carro1);
        System.out.println("Valor do tanque cheio: "+carro1.totalValorTanque(7.50));
        System.out.println();

        Carro carro2 = new Carro();
        carro2.setMarca("BMW");
        carro2.setModelo("X6");
        carro2.setCor("Preto");
        carro2.setPortas(5);
        carro2.setTanque(72);

        System.out.println(carro2);
        System.out.println("Valor do tanque cheio: "+carro2.totalValorTanque(7.50));



    }
}

class Carro{
    private String marca;
    private String modelo;
    private String cor;
    private Integer portas;
    private Integer tanque;

    public Carro(){
    }

    public Carro(String marca, String modelo, String cor, Integer portas, Integer tanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.portas = portas;
        this.tanque = tanque;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getPortas() {
        return portas;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public Integer getTanque() {
        return tanque;
    }

    public void setTanque(Integer tanque) {
        this.tanque = tanque;
    }

    double totalValorTanque(double valorCombustivel){
        return tanque * valorCombustivel;
    }

    @Override
    public String toString() {
        return marca + " - " + modelo + " - " + cor + " - " + portas + " - " + tanque;
    }
}