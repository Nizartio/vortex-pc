package com.pcbuilder.core;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pcbuilder.Component;


public class PC {
    private Component motherboard;
    private Component cpu;
    private Component ram;
    private List<Component> storageDevices = new ArrayList<>();
    private List<Component> peripherals = new ArrayList<>();

    // Constructor
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

    public void setMotherboard(Component motherboard) {
        this.motherboard = motherboard;
    }

    public void setCpu(Component cpu) {
        this.cpu = cpu;
    }

    public void setRam(Component ram) {
        this.ram = ram;
    }

    public void addStorage(Component storage) {
        storageDevices.add(storage);
    }

    public void addPeripheral(Component peripheral) {
        peripherals.add(peripheral);
    }

    public boolean replaceStorage(Component oldStorage, Component newStorage) {
        int index = storageDevices.indexOf(oldStorage);
        if (index != -1) {
            storageDevices.set(index, newStorage);
            return true;
        }
        return false;
    }

    public boolean replacePeripheral(Component oldPeripheral, Component newPeripheral) {
        int index = peripherals.indexOf(oldPeripheral);
        if (index != -1) {
            peripherals.set(index, newPeripheral);
            return true;
        }
        return false;
    }

    public Optional<Component> getComponent(String name) {
        if (motherboard != null && motherboard.getName().equalsIgnoreCase(name)) return Optional.of(motherboard);
        if (cpu != null && cpu.getName().equalsIgnoreCase(name)) return Optional.of(cpu);
        if (ram != null && ram.getName().equalsIgnoreCase(name)) return Optional.of(ram);

        for (Component component : storageDevices) {
            if (component.getName().equalsIgnoreCase(name)) return Optional.of(component);
        }

        for (Component component : peripherals) {
            if (component.getName().equalsIgnoreCase(name)) return Optional.of(component);
        }

        return Optional.empty();
    }

    public double calculateTotalPrice() {
        double total = 0;
        if (motherboard != null) total += motherboard.getPrice();
        if (cpu != null) total += cpu.getPrice();
        if (ram != null) total += ram.getPrice();
        
        for (Component s : storageDevices) total += s.getPrice();
        for (Component p : peripherals) total += p.getPrice();
        return total;
    }
}