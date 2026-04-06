package br.inatel.PCMania;

public class Computador {
    private String marca;
    private float preco;
    private MemoriaUSB msub;
    private HardwareBasico[] hardwareBasicos;
    private SistemaOperacional system;

    public Computador(String marca, float preco, String osName, int osTipo) {
        this.marca = marca;
        this.preco = preco;
        this.hardwareBasicos = new HardwareBasico[3];
        this.system = new SistemaOperacional(osName, osTipo);
    }

    public float getPreco() {
        return preco;
    }

    public void addMemoriaUSB(MemoriaUSB msub){
        this.msub = msub;
    }

    public void addHardwareBasico(String nome, float capacidade){
        for(int i = 0; i < hardwareBasicos.length; i++){
            if(hardwareBasicos[i] == null){
                hardwareBasicos[i] = new HardwareBasico(nome, capacidade);
                break;
            }
        }
    }

    public void mostraPCConfigs(){
        System.out.println("Marca: " + marca);
        System.out.printf("Preco: R$%.2f\n", preco);
        for(HardwareBasico hardware : hardwareBasicos){
            if(hardware.getNome().equals("Memória RAM") || hardware.getNome().equals("HD")){
                // Caso a memoria for menor que 1000, será considerada em Gb
                if(hardware.getCapacidade() < 1000) {
                    System.out.printf("%.0fGb de %s\n", hardware.getCapacidade(), hardware.getNome());
                }
                // Se for maior, em Tb
                else {
                    System.out.printf("%.0fTb de %s\n", (hardware.getCapacidade()/1000), hardware.getNome());
                }
            }
            else{
                System.out.printf("%s (%.0f Mhz)\n", hardware.getNome(), hardware.getCapacidade());
            }
        }
        System.out.println("Sistema Operacional " + system.getNome() + " (" + system.getTipo() + " bits)");
        if(msub != null){
            if(msub.getCapacidade() < 1000) {
                System.out.println("Acompanha " + msub.getNome() + " de " + msub.getCapacidade() + "Gb");
            }
            else {
                System.out.println("Acompanha " + msub.getNome() + " de " + (msub.getCapacidade()/1000) + "Tb");
            }
        }
    }
}
