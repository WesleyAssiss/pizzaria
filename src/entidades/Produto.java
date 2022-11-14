/*
Wesley Elbert Assis
*/

package entidades;

import java.util.Random;

public class Produto {

    private String idProduto;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        
        iniciaParametrosSistema();
    }
    
    private void iniciaParametrosSistema() {
        Random gerador = new Random();
        
        String num = "" + System.currentTimeMillis() + "" + gerador.nextInt(100);
        this.idProduto = num.substring(8);
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}

