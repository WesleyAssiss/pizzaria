/*
Wesley Elbert Assis
*/


package entidades;

public class Bebida extends Produto {

    private String mililitros;

    public Bebida(String nome, double preco, String mililitros) {
        super(nome, preco);
        this.mililitros = mililitros;
    }

    public String getMililitros() {
        return mililitros;
    }

    public void setMililitros(String mililitros) {
        this.mililitros = mililitros;
    }

}
