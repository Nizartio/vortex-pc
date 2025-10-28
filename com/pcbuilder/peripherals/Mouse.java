package com.pcbuilder.peripherals;
import com.pcbuilder.Component;

public class Mouse extends Component {
    private String jenis;
    private int jumlahTombol;

    public Mouse() {
        super("noName", 0);
    }

    public Mouse(String name, double price) {
        super(name, price);
    }

    public Mouse(String name, double price, String jenis, int jumlahTombol) {
        super(name, price);
        this.jenis = jenis;
        this.jumlahTombol = jumlahTombol;
    }

    public String getJenis() {
        return this.jenis;
    }

    public int getJumlahTombol() {
        return this.jumlahTombol;
    }
}