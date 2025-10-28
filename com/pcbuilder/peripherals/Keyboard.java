package com.pcbuilder.peripherals;
import com.pcbuilder.Component;

public class Keyboard extends Component {
    private String layout; 
    private String jenisSwitch; 

    public Keyboard() {
        super("noName", 0);
    }

    public Keyboard(String name, double price) {
        super(name, price);
    }

    public Keyboard(String name, double price, String layout, String jenisSwitch) {
        super(name, price);
        this.layout = layout;
        this.jenisSwitch = jenisSwitch;
    }

    public String getLayout() {
        return this.layout;
    }

    public String getJenisSwitch() {
        return this.jenisSwitch;
    }
}