package entidades;

public class Atendente extends Funcionario {

    private int ramal;
    private double salario;
    
    public Atendente(int ramal, double salario, String rg, String cpf, String dataNascimento, String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        super(rg, cpf, dataNascimento, nome, telefone, email, cep, endereco, senha);
        this.ramal = ramal;
        this.salario = salario;
        this.email = email;
        this.login = this.email;
        this.senha = senha;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString() {
        return "Atendente: " 
                + "\nNome: " 
                + this.nome
                + "\nRamal da empresa: "
                + this.ramal
                + "\nTelefone: "
                + this.telefone
                + "\nCEP: "
                + this.cep
                + "\nEndereço: "
                + getEndereco().getRua()
                + ", "
                + getEndereco().getNumero()
                + "\nReferência: "
                + getEndereco().getReferencia()
                + "\nEmail: "
                + this.email
                + "\nSalário: R$ "
                + getSalario();
    }

}
