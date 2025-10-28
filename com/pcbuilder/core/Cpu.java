package com.pcbuilder.core;
import com.pcbuilder.Component;

public class Cpu extends Component{
    protected int core;
    protected int daya;

    public Cpu() {
        super("noName",0);
    }
    public Cpu(String name, double price) {
        super(name, price);
    }
    public Cpu(String name, double price, int core, int daya) {
        super(name, price);
        this.core = core;
        this.daya = daya;
    }
    public Boolean runCPU(){
        if (this.core > 1) {
            System.out.println("CPU berjalan");
            return true;
        } else {
            return false;
        }
    }
}
