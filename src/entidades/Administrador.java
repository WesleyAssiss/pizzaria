/*
Wesley Elbert Assis
*/

package entidades;

public class Administrador extends Funcionario {
    
    private double salario;

    public Administrador(String rg, String cpf, String dataNascimento, String nome, String telefone, String email, String cep, Endereco endereco, String senha, double salario) {
        super(rg, cpf, dataNascimento, nome, telefone, email, cep, endereco, senha);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
