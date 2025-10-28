package com.pcbuilder.core;
import com.pcbuilder.Component;

public class Motherboard extends Component {
    private String bios;
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
    public String getBios() {
        return this.bios;
    }
}
