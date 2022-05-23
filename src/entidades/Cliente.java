package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente extends Usuario {

    private String idCliente;
    
    List<Endereco> enderecos = new ArrayList<>();
    public List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String telefone, String email, String cep, String senha) {
        super(nome, telefone, email, cep, senha);
        
        iniciaParametrosSistema();
    }

    public Cliente(String nome, String telefone, String email, String cep, Endereco endereco, String senha) {
        super(nome, telefone, email, cep, endereco, senha);
        
        iniciaParametrosSistema();
    }

    private void iniciaParametrosSistema() {
        Random gerador = new Random();

        String num = "" + System.currentTimeMillis() + "" + gerador.nextInt(100);
        this.idCliente = num.substring(7);
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
    
    public boolean adicionarPedido(Pedido pedido) {
        int tamanhoPedidos = pedidos.size();
        pedidos.add(pedido);
        
        return pedidos.size() == tamanhoPedidos + 1;
    }
    
    public boolean excluirPedido(String idPedido){
        for(int i=0; i<pedidos.size(); i++) {
            if(pedidos.get(i).getIdPedido().equals(idPedido)){
                pedidos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Cliente:"
                + "\nID do cliente: "
                + this.idCliente
                + "\nNome: "
                + this.nome
                + "\nTelefone: "
                + this.telefone
                + "\nEmail: "
                + this.email
                + "\nCEP: " 
                + this.cep
                + "\nEndereço: "
                + getEndereco().getRua()
                + ", "
                + getEndereco().getNumero()
                + "\nReferência: "
                + getEndereco().getReferencia();
    }

}
