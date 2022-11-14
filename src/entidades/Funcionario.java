/*
Wesley Elbert Assis
*/

package entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Funcionario extends Usuario {

    protected String idFuncionario;
    protected String rg;
    protected String cpf;
    protected String dataNascimento;
    protected Date dataContratação;

    public Funcionario(String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        super(nome, telefone, email, cep, endereco, senha);
    }
    
    public Funcionario(String rg, String cpf, String dataNascimento, String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        super(nome, telefone, email, cep, endereco, senha);
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

        iniciaParametrosSistema();
    }

    private void iniciaParametrosSistema() {
        Random gerador = new Random();

        String num = "" + System.currentTimeMillis() + "" + gerador.nextInt(100);
        this.idFuncionario = num.substring(9);
        
        Calendar hoje = Calendar.getInstance();
        this.dataContratação = hoje.getTime();
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public Date getDataContratação() {
        return dataContratação;
    }

}


