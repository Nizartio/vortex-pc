package com.pcbuilder.core;
import com.pcbuilder.Component;

public class Ram extends Component{
    private String tipe;
    private int kapasitas;

    public Ram() {
        super("noName",0);
    }
    public Ram(String name, double price) {
        super(name, price);
    }

    public Ram(String name, double price, String tipe, int kapasitas) {
        super(name, price);
        this.tipe = tipe;
        this.kapasitas = kapasitas;
    }
    public Boolean runRam() {
        if (this.kapasitas > 0) {
            return true;
        } else {
            return false;
        }
    }
    public int getKapasitas() {
        return this.kapasitas;
    }
    public String getTipe() {
        return this.tipe;
    }
}
