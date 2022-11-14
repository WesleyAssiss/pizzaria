/*
Wesley Elbert Assis
*/

package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Pedido {

    private Cliente cliente;
    private String idPedido;
    private Funcionario atendente;
    private Funcionario entregador;
    private Endereco enderecoEntrega;
    private Date dataEHoraPedido;
    private Status statusPedido;
    
    List<ItemPedido> produtos = new ArrayList<>();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Pedido(Cliente cliente, Funcionario atendente, Entregador entregador, Endereco endereco) {
        this.cliente = cliente;
        this.atendente = atendente;
        this.entregador = entregador;
        this.enderecoEntrega = endereco;
        this.statusPedido = Status.NOVO;
        
        iniciaParametrosSistema();
    }
    
    public Pedido(Cliente cliente, Entregador entregador, Endereco endereco) {
        this.cliente = cliente;
        this.entregador = entregador;
        this.enderecoEntrega = endereco;
        this.statusPedido = Status.NOVO;
        
        iniciaParametrosSistema();
    }
    
    private void iniciaParametrosSistema(){ 
        Random gerador = new Random();
        this.idPedido = "" + System.currentTimeMillis() + "" + gerador.nextInt(100);
        
        Calendar hoje = Calendar.getInstance();
        this.dataEHoraPedido = hoje.getTime();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public List<ItemPedido> getProdutos() {
        return produtos;
    }

    public Funcionario getAtendente() {
        return atendente;
    }

    public void setAtendente(Funcionario atendente) {
        this.atendente = atendente;
    }

    public Funcionario getEntregador() {
        return entregador;
    }

    public void setEntregador(Funcionario entregador) {
        this.entregador = entregador;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Date getDataEHoraPedido() {
        return dataEHoraPedido;
    }

    public Status getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Status statusPedido) {
        this.statusPedido = statusPedido;
    }
    
    public void adicionarProduto(ItemPedido item){
        produtos.add(item);
    }
    
    public double subTotal() {
        double soma = 0.0;
        for(int i=0; i<produtos.size();i++) {
            soma += (produtos.get(i).getQuantidade() * produtos.get(i).getProduto().getPreco());
        }
        return soma;
    }
    
    public String itemPedido(){
        String p = null;
        for(int i=0; i< produtos.size(); i++) {
            p = "Nome: " + produtos.get(i).getProduto().getNome() + ", Quantidade: " + produtos.get(i).getQuantidade() + ", Preço: " + produtos.get(i).getProduto().getPreco();
        }
        return p;
    }
    
    public void atualizarStatus(Status novoStatus){
        this.statusPedido = novoStatus;
    }
    
    @Override
    public String toString(){
        return "Pedido:"
                + "\nID do pedido: " + idPedido
                + "\nNome do cliente: " + cliente.nome
                + "\nItens do pedido: " + itemPedido()
                + "\nEndereco de entrega: " + cliente.getEndereco().getRua() + ", nº " + cliente.getEndereco().getNumero()
                + "\nReferência: " + cliente.getEndereco().getReferencia() 
                + "\nEntregador: " + entregador.nome
                + "\nValor do pedido: R$ " + subTotal()
                + "\nData do pedido: " + sdf.format(dataEHoraPedido)
                + "\nStatus do pedido: " + statusPedido.toString();
    }
}
