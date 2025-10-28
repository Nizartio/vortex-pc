package src.com.vortexpc.model.components.peripheral;
import src.com.vortexpc.model.components.Component;

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
    public boolean runMonitor(){
        if (this.ukuran > 0) {
            return true;
        } else {
            return false;
        }
    }
    public int getUkuran() {
        return this.ukuran;
    }
    public String getTipe() {
        return this.resolusi;
    }
}
