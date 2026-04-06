package br.inatel.PCManiaPedidos;

public class Cliente {
    private String nome, cpf;
    private float total = 0;
    private int[] pedidos = new int[3];

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int[] getPedidos() {
        return pedidos;
    }

    public float getTotal() {
        return total;
    }

    public float calculaTotalCompra(float preco){
        total += preco;
        return total;
    }

    public void addPedidos(int promo){
        for(int i = 0; i < pedidos.length; i++){
            if (pedidos[i] == 0){
                pedidos[i] = promo;
                break;
            }
        }
    }
}
