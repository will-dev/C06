package br.inatel.PCMania;

import br.inatel.PCManiaPedidos.Cliente;
import br.inatel.PCManiaPedidos.ProcessarPedidos;

public class Main {
    static void main(String[] args) {
        Computador promo1 = new Computador("Apple", 552, "macOS", 64);
        promo1.addHardwareBasico("Pentium Core i3", 2200);
        promo1.addHardwareBasico("Memória RAM", 8);
        promo1.addHardwareBasico("HD", 500);
        MemoriaUSB msub1 = new MemoriaUSB("Pen-drive", 16);
        promo1.addMemoriaUSB(msub1);

        Computador promo2 = new Computador("Samsumg", 552+1234, "Windows 8", 64);
        promo2.addHardwareBasico("Pentium Core i5", 3370);
        promo2.addHardwareBasico("Memória RAM", 16);
        promo2.addHardwareBasico("HD", 1000);
        MemoriaUSB msub2 = new MemoriaUSB("Pen-drive", 32);
        promo2.addMemoriaUSB(msub2);

        Computador promo3 = new Computador("Dell", 552+5678, "Windows 10", 64);
        promo3.addHardwareBasico("Pentium Core i7", 4500);
        promo3.addHardwareBasico("Memória RAM", 32);
        promo3.addHardwareBasico("HD", 2000);
        MemoriaUSB msub3 = new MemoriaUSB("HD Externo", 1000);
        promo3.addMemoriaUSB(msub3);

        Computador[] promocoes = {promo1, promo2, promo3};
        ProcessarPedidos.setPromocoes(promocoes);
        Cliente cliente = ProcessarPedidos.CadastrarCliente();
        ProcessarPedidos.MostrarPromocoes();
        ProcessarPedidos.RealizarPedidos(cliente);
        ProcessarPedidos.FinalizarPedido(cliente);
    }
}
