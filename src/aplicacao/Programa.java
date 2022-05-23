package aplicacao;

import entidades.Administrador;
import entidades.Atendente;
import entidades.Bebida;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Entregador;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Pizza;
import entidades.Status;
import entidades.Usuario;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Pizza p1 = new Pizza("Calabresa", 32.90);
        Pizza p2 = new Pizza("Frango com catupiry", 32.90);
        Pizza p3 = new Pizza("Marguerita", 32.90);
        Pizza p4 = new Pizza("Portuguesa", 32.90);

        Bebida b1 = new Bebida("Coca Cola", 3.50, "350ml");
        Bebida b2 = new Bebida("Cerveja", 4.00, "350ml");
        Bebida b3 = new Bebida("Suco de Laranja", 6.00, "500ml");

        System.out.println("############################################");
        System.out.println("Pizzas:");

        System.out.println("1-" + p1.getNome() + " --> Preço: RS " + p1.getPreco());
        System.out.println("2-" + p2.getNome() + " --> Preço: RS " + p2.getPreco());
        System.out.println("3-" + p3.getNome() + " --> Preço: RS " + p3.getPreco());
        System.out.println("4-" + p4.getNome() + " --> Preço: RS " + p4.getPreco());

        System.out.println("");
        System.out.println("Bebidas:");

        System.out.println("5-" + b1.getNome() + " --> Preço: RS " + b1.getPreco());
        System.out.println("6-" + b2.getNome() + " --> Preço: RS " + b2.getPreco());
        System.out.println("7-" + b3.getNome() + " --> Preço: RS " + b3.getPreco());

        System.out.println("############################################");

        Usuario us = new Usuario();
        Cliente cliente = new Cliente("Maria", "36498900", "maria@gmail.com", "36420000", new Endereco("Avenida São Carlos", "1400", "Perto do hospital"), "Maria123@");
        Atendente atendente = new Atendente(123, 1500.00, "MG12345678", "12345678900", "01/12/2001", "José", "37410199", "jose@gmail.com", "36420000", new Endereco("rua das flores", "222", "Perto da praça"), "Jose123@");
        Entregador entregador = new Entregador("m42g18", 1300.00, "MG12439845", "98765431200", "15/07/1993", "Pedro", "39387165", "pedro@gmail.com", "36420000", new Endereco("rua da rosas", "245", "Próximo ao shopping"), "Pedro123@");
        Administrador adm = new Administrador("MG87654321", "17302818200", "02/03/1983", "Carlos", "39381245", "carlos@gmail.com", "36420000", new Endereco("rua josé guilherme", "134", "Próximo a escola"), "Carlos123@", 3000.00);

        us.adicionarUsuario(cliente);
        us.adicionarUsuario(atendente);
        us.adicionarUsuario(entregador);
        us.adicionarUsuario(adm);

        System.out.println("");
        int opcao = 0;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1-Funcionario");
            System.out.println("2-Cliente");

            opcao = in.nextInt();
        } while (opcao != 1 && opcao != 2);

        char temCadastro;
        boolean logado;
        if (opcao == 1) {
            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1-Atendente");
                System.out.println("2-Entregador");
                System.out.println("3-Administrador");

                opcao = in.nextInt();
            } while (opcao < 1 && opcao > 2);

            if (opcao == 1) {
                System.out.println("Login para teste: jose@gmail.com e Jose123@");
                System.out.println("");

                System.out.print("Digite seu login (email): ");
                String email = in.next();
                System.out.print("Digite sua senha: ");
                String senha = in.next();

                logado = us.logar(email, senha);

                if (logado) {
                    System.out.println("");
                    System.out.println("Login efetuado com sucesso!");

                    do {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1-Cadastrar cliente");
                        System.out.println("2-Adicionar um novo pedido");
                        System.out.println("3-Atualizar o status de um pedido existente");
                        System.out.println("4-Excluir um pedido");

                        opcao = in.nextInt();
                    } while (opcao < 1 && opcao > 4);

                    switch (opcao) {
                        case 1:
                            in.nextLine();
                            System.out.println("");
                            System.out.println("Cadastro de novo cliente:");
                            System.out.print("Digite o nome: ");
                            String nome = in.nextLine();
                            System.out.print("Digite o telefone: ");
                            String telefone = in.next();
                            System.out.print("Digite um email: ");
                            email = in.next();
                            System.out.print("Digite o CEP: ");
                            String cep = in.next();
                            in.nextLine();
                            System.out.print("Digite o nome da rua: ");
                            String rua = in.nextLine();
                            System.out.print("Digite o número da casa: ");
                            String numero = in.next();
                            in.nextLine();
                            System.out.print("Digite uma referência: ");
                            String referencia = in.nextLine();
                            System.out.print("Digite uma senha: ");
                            senha = in.next();

                            Cliente cliente2 = new Cliente(nome, telefone, email, cep, new Endereco(rua, numero, referencia), senha);
                            us.adicionarUsuario(cliente2);

                            System.out.println("");
                            System.out.println(cliente2);
                            break;
                        case 2: {
                            System.out.println("Pra facilitar eu já passei o cliente, atendente, entregador e o endereço nos parametros.");
                            System.out.println("");
                            Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());
                            boolean adicionado = cliente.adicionarPedido(pedido);
                            cliente.adicionarEndereco(cliente.getEndereco());
                            int n, quantidade = 0;
                            do {
                                System.out.println("Digite 0 para sair....");
                                System.out.println("Entre com pelo menos 1 produto antes de sair.");

                                System.out.print("Digite o número correspondente ao produto (pizza ou bebida): ");
                                n = in.nextInt();

                                if (n != 0) {
                                    System.out.print("Digite a quantidade: ");
                                    quantidade = in.nextInt();

                                    if (quantidade != 0) {
                                        ItemPedido iPedido;
                                        switch (n) {
                                            case 1:
                                                iPedido = new ItemPedido(p1, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 2:
                                                iPedido = new ItemPedido(p2, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 3:
                                                iPedido = new ItemPedido(p3, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 4:
                                                iPedido = new ItemPedido(p4, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 5:
                                                iPedido = new ItemPedido(b1, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 6:
                                                iPedido = new ItemPedido(b2, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                            case 7:
                                                iPedido = new ItemPedido(b3, quantidade);
                                                pedido.adicionarProduto(iPedido);
                                                break;
                                        }
                                    }
                                }
                            } while (n != 0 && quantidade != 0);
                            System.out.println("");
                            if (adicionado) {
                                System.out.println("Pedido adicionado com sucesso!");
                                System.out.println("");
                                System.out.println(pedido);
                            }
                            break;
                        }
                        case 3: {
                            Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());
                            System.out.println(pedido);
                            System.out.println("");
                            System.out.print("Digite o novo status (PRODUCAO ou ENVIADO): ");
                            String status = in.next();
                            pedido.atualizarStatus(Status.valueOf(status));
                            System.out.println("");
                            System.out.println(pedido);
                            break;
                        }
                        default: {
                            Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());
                            cliente.adicionarPedido(pedido);
                            
                            System.out.println(pedido);
                            
                            System.out.println("");
                            System.out.println("Digite o ID do pedido acima para excluí-lo");
                            String idPedido = in.next();
                            
                            boolean exluido = cliente.excluirPedido(idPedido);
                            
                            if(exluido) {
                                System.out.println("O pedido foi excluido com sucesso!");
                            }
                            break;
                        }
                    }
                }
            } else if (opcao == 2) {
                System.out.println("Atualizar o status de um pedido existente"
                        + "");
                Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());
                System.out.println(pedido);

                System.out.println("");
                System.out.print("Digite o novo status (PRDUCAO ou ENVIADO): ");
                String status = in.next();

                pedido.atualizarStatus(Status.valueOf(status));

                System.out.println("");
                System.out.println(pedido);
            } else {
                System.out.println("Assumindo que o administrador já tem cadastro");

                System.out.println("Login para teste: carlos@gmail.com e Carlos123@");

                System.out.println("");
                System.out.print("Digite seu login (email): ");
                String email = in.next();
                System.out.print("Digite sua senha: ");
                String senha = in.next();

                logado = us.logar(email, senha);

                if (logado) {
                    System.out.println("");
                    System.out.println("Login efetuado com sucesso!");

                    do {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1-Cadastrar funcionario");
                        System.out.println("2-Excluir um usuário");

                        opcao = in.nextInt();
                    } while (opcao < 1 && opcao > 3);

                }
                switch (opcao) {
                    case 1:
                        System.out.print("Qual funcionario você que cadastrar (1-Atendente ou 2-Entregador)? ");
                        opcao = in.nextInt();
                        in.nextLine();
                        if (opcao == 1) {
                            System.out.println("Cadastro de Atendente:");
                            System.out.println("");

                            System.out.print("Digite o nome: ");
                            String nome = in.nextLine();
                            System.out.print("Ramal da empresa: ");
                            int ramal = Integer.parseInt(in.nextLine());
                            System.out.print("Digite o telefone pessoal: ");
                            String telefone = in.next();
                            System.out.print("Digite o RG: ");
                            String rg = in.next();
                            System.out.print("Digite o CPF: ");
                            String cpf = in.next();
                            System.out.print("Digite a data de nascimento: ");
                            String dataNascimento = in.next();
                            System.out.print("Digite um email: ");
                            email = in.next();
                            System.out.print("Digite o CEP: ");
                            String cep = in.next();
                            System.out.print("Digite o salário: ");
                            double salario = in.nextDouble();
                            in.nextLine();
                            System.out.print("Digite o nome da rua: ");
                            String rua = in.nextLine();
                            System.out.print("Digite o número da casa: ");
                            String numero = in.next();
                            in.nextLine();
                            System.out.print("Digite uma referência: ");
                            String referencia = in.nextLine();
                            System.out.print("Digite uma senha: ");
                            senha = in.next();

                            Atendente atendente1 = new Atendente(ramal, salario, rg, cpf, dataNascimento, nome, telefone, email, cep, new Endereco(rua, numero, referencia), senha);
                            us.adicionarUsuario(atendente1);

                            System.out.println("");
                            System.out.println(atendente1);
                        } else {
                            System.out.println("Cadastro de Entregador:");
                            System.out.println("");

                            System.out.print("Digite o número da placa: ");
                            String placa = in.next();
                            System.out.print("Digite o salário: ");
                            double salario = in.nextDouble();
                            System.out.print("Digite o RG: ");
                            String rg = in.next();
                            System.out.print("Digite o CPF: ");
                            String cpf = in.next();
                            System.out.print("Digite a data de nascimento: ");
                            String dataNascimento = in.next();
                            in.nextLine();
                            System.out.print("Digite o nome: ");
                            String nome = in.nextLine();
                            System.out.print("Digite o telefone: ");
                            String telefone = in.next();
                            System.out.print("Digite um email: ");
                            email = in.next();
                            System.out.print("Digite o CEP: ");
                            String cep = in.next();
                            in.nextLine();
                            System.out.print("Digite o nome da rua: ");
                            String rua = in.nextLine();
                            System.out.print("Digite o número da casa: ");
                            String numero = in.next();
                            in.nextLine();
                            System.out.print("Digite uma referência: ");
                            String referencia = in.nextLine();
                            System.out.print("Digite uma senha: ");
                            senha = in.next();

                            Entregador entregador1 = new Entregador(placa, salario, rg, cpf, dataNascimento, nome, telefone, email, cep, new Endereco(rua, numero, referencia), senha);
                            us.adicionarUsuario(entregador1);

                            System.out.println("");
                            System.out.println(entregador1);
                        }
                        break;
                    default:
                        
                        break;
                }
            }
        } else {
            System.out.print("Você já tem cadastro (s/n)");
            temCadastro = in.next().charAt(0);

            if (temCadastro == 'n') {
                System.out.println("Cadastro de cliente:");
                System.out.print("Digite seu nome: ");
                String nome = in.nextLine();
                in.nextLine();
                System.out.print("Digite seu telefone: ");
                String telefone = in.next();
                System.out.print("Digite seu email: ");
                String email = in.next();
                System.out.print("Digite seu cep: ");
                String cep = in.next();
                System.out.print("Digite uma senha: ");
                String senha = in.next();

                System.out.print("Deseja cadastrar um endereço agora (s/n)? ");
                opcao = in.next().charAt(0);

                if (opcao == 's') {
                    System.out.print("Digite o nome da rua: ");
                    String rua = in.nextLine();
                    in.nextLine();
                    System.out.print("Digite o número: ");
                    String numero = in.next();
                    in.nextLine();
                    System.out.print("Digite uma referência: ");
                    String referencia = in.nextLine();

                    Cliente cliente2 = new Cliente(nome, telefone, email, cep, new Endereco(rua, numero, referencia), senha);
                    us.adicionarUsuario(cliente2);
                    System.out.println("Cadastro efeutado com sucesso!");

                } else {
                    Cliente cliente2 = new Cliente(nome, telefone, email, cep, senha);
                    us.adicionarUsuario(cliente2);
                    System.out.println("Cadastro efeutado com sucesso!");
                }
            }
            System.out.println("");
            if (temCadastro == 's') {
                System.out.println("Login para teste: maria@gmail.com e Maria123@");
            }

            System.out.println("");
            System.out.print("Digite seu login (email): ");
            String email = in.next();
            System.out.print("Digite sua senha: ");
            String senha = in.next();

            logado = us.logar(email, senha);

            if (logado) {
                System.out.println("");
                System.out.println("Login efetuado com sucesso!");

                do {
                    System.out.println("Escolha uma opção:");
                    System.out.println("1-Adicionar produto");
                    System.out.println("2-Listar compras");

                    opcao = in.nextInt();
                } while (opcao < 1 && opcao > 5);
            }

            if (opcao == 1) {
                Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());

                boolean adicionado = cliente.adicionarPedido(pedido);
                cliente.adicionarEndereco(cliente.getEndereco());

                int n, quantidade = 0;
                do {
                    System.out.println("Digite 0 para sair....");
                    System.out.println("Entre com pelo menos 1 produto antes de sair.");

                    System.out.print("Digite o número correspondente ao produto (pizza ou bebida): ");
                    n = in.nextInt();

                    if (n != 0) {
                        System.out.print("Digite a quantidade: ");
                        quantidade = in.nextInt();

                        if (quantidade != 0) {
                            ItemPedido iPedido;
                            switch (n) {
                                case 1:
                                    iPedido = new ItemPedido(p1, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 2:
                                    iPedido = new ItemPedido(p2, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 3:
                                    iPedido = new ItemPedido(p3, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 4:
                                    iPedido = new ItemPedido(p4, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 5:
                                    iPedido = new ItemPedido(b1, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 6:
                                    iPedido = new ItemPedido(b2, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                                case 7:
                                    iPedido = new ItemPedido(b3, quantidade);
                                    pedido.adicionarProduto(iPedido);
                                    break;
                            }
                        }
                    }
                } while (n != 0 && quantidade != 0);

                System.out.println("");
                if (adicionado) {
                    System.out.println("Pedido adicionado com sucesso!");
                    System.out.println("");
                    System.out.println(pedido);
                }
            } else{
                Pedido pedido = new Pedido(cliente, atendente, entregador, cliente.getEndereco());
                cliente.adicionarPedido(pedido);
                
                System.out.println("Lista com todas as compras:");

                for (int i = 0; i < cliente.pedidos.size(); i++) {
                    System.out.println(cliente.pedidos.get(i));                 
                }
            }
        }
    }
}
