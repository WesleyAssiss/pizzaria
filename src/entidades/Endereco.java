/*
Wesley Elbert Assis
*/

package entidades;

public class Endereco {

    private String rua;
    private String numero;
    private String referencia;

    public Endereco(String rua, String numero, String referencia) {
        this.rua = rua;
        this.numero = numero;
        this.referencia = referencia;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
