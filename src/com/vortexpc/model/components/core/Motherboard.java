package src.com.vortexpc.model.components.core;

import src.com.vortexpc.model.components.Component;

public class Motherboard extends Component {
    private String bios;
    public String getBios() {
        return this.bios;
    }
    public Motherboard() {
        super("noName",0);
    }
    public Motherboard(String name, double price) {
        super(name, price);
    }
    public Motherboard(String name, double price, String bios) {
        super(name, price);
        this.bios = bios;
    }
    public void setBios(String bios) {
        this.bios = bios;
    }
    public void runBios(){
        System.out.println("Bios berjalan");
    }
}
