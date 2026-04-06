package br.inatel.PCManiaPedidos;

import br.inatel.PCMania.Computador;
import java.util.Scanner;

public class ProcessarPedidos {
    private static Computador[] promocoes = new Computador[3];
    private static Scanner entrada = new Scanner(System.in);

    public static void setPromocoes(Computador[] promocoes) {
        ProcessarPedidos.promocoes = promocoes;
    }

    public static Cliente CadastrarCliente() {
        System.out.println("\nPara realizar a compra, primeiro dê suas informações para o seu cadastro no nosso sistema.\n");
        System.out.println("Nome:");
        String nome = entrada.nextLine();
        System.out.println("CPF:");
        String cpf = entrada.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        System.out.println("Tudo pronto para iniciar seu pedido.");
        return cliente;
    }

    public static void MostrarPromocoes() {
        System.out.println("\nOs computadores em promoção disponíveis na loja são:\n");
        for(int i = 0; i < promocoes.length; i++){
            System.out.println("Promoção " + (i+1) + ":");
            promocoes[i].mostraPCConfigs();
            System.out.println();
        }
    }

    public static void RealizarPedidos(Cliente cliente){
        System.out.println("\nQuais promoções você gostaria de aproveitar?");
        System.out.println("1 = Promoção 1  |  2 = Promoção 2  |  3 = Promoção 3  |  0 = Finalizar Compra");
        int escolha, qtd = 0;
        do{
            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    cliente.calculaTotalCompra(promocoes[0].getPreco());
                    cliente.addPedidos(1);
                    System.out.println("Computador da Promoção 1 foi adicionado ao carrinho.");
                    qtd++;
                    break;
                case 2:
                    cliente.addPedidos(2);
                    cliente.calculaTotalCompra(promocoes[1].getPreco());
                    System.out.println("Computador da Promoção 2 foi adicionado ao carrinho.");
                    qtd++;
                    break;
                case 3:
                    cliente.addPedidos(3);
                    cliente.calculaTotalCompra(promocoes[2].getPreco());
                    System.out.println("Computador da Promoção 3 foi adicionado ao carrinho.");
                    qtd++;
                    break;
                case 0:
                    if(qtd < 2){
                        System.out.println("Ação inválida. Para acessar a promoção, é preciso comprar no mínimo 2 produtos.");
                    }
                    break;
            }
            System.out.println("\nGostaria de fazer mais um pedido?");
            System.out.println("1 = Promoção 1  |  2 = Promoção 2  |  3 = Promoção 3  |  0 = Finalizar Compra");
        }while(escolha != 0 || qtd < 2);
        System.out.println("Pedido enviado...");
    }

    public static void FinalizarPedido(Cliente cliente){
        System.out.println("\n============================================");
        System.out.println("         Finalização do Pedido");
        System.out.printf("Comprador: %s      CPF: %s\n", cliente.getNome(), cliente.getCpf());
        System.out.println("-------------------------------------------");
        System.out.println("Produtos:\n");
        for(int pedido : cliente.getPedidos()){
            if (pedido != 0){
                promocoes[(pedido-1)].mostraPCConfigs();
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------");
        System.out.printf("Total da compra: R$%.2f\n", cliente.getTotal());
        System.out.println("============================================");
    }
}
