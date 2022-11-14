/*
Wesley Elbert Assis
*/

package entidades;

public class Entregador extends Funcionario {

    private String placa;
    private double salario;

    public Entregador(String placa, double salario, String rg, String cpf, String dataNascimento, String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        super(rg, cpf, dataNascimento, nome, telefone, email, cep, endereco, senha);
        this.placa = placa;
        this.salario = salario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "Entregador: " 
                + "\nNome: " 
                + this.nome
                + "\nTelefone: "
                + this.telefone
                + "\nCEP: "
                + this.cep
                + "\nEndereço: "
                + this.endereco.getRua()
                + ", "
                + this.endereco.getNumero()
                + "\nReferência: "
                + this.endereco.getReferencia()
                + "\nEmail: "
                + this.email
                + "\nSalário: R$ "
                + getSalario();
    }
}
