package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String cep;
    protected Endereco endereco;
    protected String login;
    protected String senha;

    public List<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String telefone, String email, String cep, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.senha = senha;
    }

    public Usuario(String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.login = this.email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean logar(String login, String senha) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean excluirUsuario(String emailUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(emailUsuario)) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removerUsuario(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return usuarios.get(0).nome + " " + usuarios.get(0).getSenha();
    }
}
