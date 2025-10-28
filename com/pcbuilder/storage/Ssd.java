package com.pcbuilder.storage;
import com.pcbuilder.Component;

public class Ssd extends Component{
    protected String tipe;
    protected int kapasitas;

    public Ssd() {
        super("noName",0);
    }
    public Ssd(String name, double price) {
        super(name, price);
    }
    public Ssd(String name, double price, String tipe, int kapasitas) {
        super(name, price);
        this.tipe = tipe;
        this.kapasitas = kapasitas;
    }
    public boolean runSSD(){
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
