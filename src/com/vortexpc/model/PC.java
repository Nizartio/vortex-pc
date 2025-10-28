package src.com.vortexpc.model;
import java.util.ArrayList;
import java.util.List;

import src.com.vortexpc.model.components.core.*;
import src.com.vortexpc.model.components.Component;

public class PC {
    private Component motherboard;
    private Component cpu;
    private Component ram;
    private List<Component> storageDevices = new ArrayList<>();
    private List<Component> peripherals = new ArrayList<>();

    public PC() {
        this.motherboard = new Motherboard();
        this.cpu = new Cpu();
        this.ram = new Ram();
    }
    public PC(Component motherboard, Component cpu, Component ram) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
    }
    public void setCore(Component motherboard, Component cpu, Component ram) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
    }
    public void addStorage(Component storage) {
        storageDevices.add(storage);
    }

    public void addPeripheral(Component peripheral) {
        peripherals.add(peripheral);
    }

    public double calculateTotalPrice() {
        double total = 0;
        total += motherboard.getPrice() + cpu.getPrice() + ram.getPrice();
        for (Component s : storageDevices) total += s.getPrice();
        for (Component p : peripherals) total += p.getPrice();
        return total;
    }
}
