package com.pcbuilder.peripherals;
import com.pcbuilder.Component;

public class Monitor extends Component{
    private int ukuran;
    private String resolusi;

    public Monitor() {
        super("noName",0);
    }
    public Monitor(String name, double price) {
        super(name, price);
    }
    public Monitor(String name, double price, int ukuran, String resolusi) {
        super(name, price);
        this.ukuran = ukuran;
        this.resolusi = resolusi;
    }
    public int getUkuran() {
        return this.ukuran;
    }
    public String getTipe() {
        return this.resolusi;
    }
}
