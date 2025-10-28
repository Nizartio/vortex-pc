import com.pcbuilder.*;
import com.pcbuilder.core.*;
import com.pcbuilder.peripherals.*;
import com.pcbuilder.storage.*;
import com.pcbuilder.reporting.*;
import java.util.Optional;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("--- UJI COBA APLIKASI KONFIGURATOR PC (VORTEX PC SOLUTIONS) ---");

        System.out.println("\n[1] Mempersiapkan Komponen Awal...");
        
        // Core Components
        Motherboard mb_a = new Motherboard("Motherboard keren", 150.00, "F1");
        Cpu cpu_a = new Cpu("CPU keren", 180.00, 6, 65);
        Ram ram_a = new Ram("Ram keren", 80.00, "DDR4", 16);
        
        // Storage & Peripheral (Untuk dipasang pertama kali)
        Ssd ssd_a = new Ssd("SSD keren", 60.00, "NVMe", 500);
        Keyboard kb_a = new Keyboard("Keyboard keren", 45.00, "TKL", "Membrane");
        Mouse mo_a = new Mouse("Mouse keren", 45.00,"gaming", 5);
        
        // Komponen Upgrade/Pengganti
        Ssd ssd_b = new Ssd("Ssd lebih keren", 120.00, "NVMe", 1000); // Upgrade Storage
        
        // 2. Buat PC dan Pasang Komponen Awal
        PC pcRakit = new PC(mb_a, cpu_a, ram_a);
        pcRakit.addStorage(ssd_a);
        pcRakit.addPeripheral(kb_a);
        pcRakit.addPeripheral(mo_a);

        System.out.println("\n[2] PC Awal Terpasang.");
        System.out.println("MB: " + mb_a.getName() + " | CPU: " + cpu_a.getName());
        System.out.println("Storage: " + ssd_a.getName());
        System.out.printf("Total Harga Awal: $%.2f%n", pcRakit.calculateTotalPrice());
        
        System.out.println("\n[4] Uji Get Component (Cari RAM):");
        Optional<Component> ramFound = pcRakit.getComponent("Ram keren");
        ramFound.ifPresent(c -> {
            System.out.println("Ditemukan: " + c.getName());
            System.out.println("Harga: $" + c.getPrice());
        });

        System.out.println("\n[5] Uji Upgrade Core (CPU):");
        Cpu cpu_b = new Cpu("Cpu lebih keren", 300.00, 8, 105);
        pcRakit.setCpu(cpu_b);
        System.out.println("CPU berhasil di-upgrade ke: " + cpu_b.getName());
        System.out.printf("Total Harga Sekarang: $%.2f%n", pcRakit.calculateTotalPrice());

        System.out.println("\n[6] Uji Replace Storage:");
        boolean replaced = pcRakit.replaceStorage(ssd_a, ssd_b);
        System.out.println("Storage 'Ssd keren' diganti 'Ssd lebih keren'. Berhasil? " + replaced);
        
        Optional<Component> newStorage = pcRakit.getComponent(ssd_b.getName());
        newStorage.ifPresent(c -> System.out.println("Storage Baru: " + c.getName()));
        System.out.printf("Total Harga Akhir: $%.2f%n", pcRakit.calculateTotalPrice());

        PCReportGenerator reporter = new PCReportGenerator();
        reporter.generateReport(pcRakit);
    }
}