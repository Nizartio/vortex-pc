1. Arsitektur & Desain

Kritik Arsitektur (Periferal/Storage):

    Desain Komponen Periferal/Storage Logis (Aggregation): Ya, desain Anda menggunakan List<Component> untuk storageDevices dan peripherals sangat logis dan mewakili Aggregation (komponen-komponen tersebut dapat eksis tanpa objek PC ). Fleksibilitas untuk menambahkan komponen baru sudah terpenuhi.

    Harusnya Menggunakan Interface? Ya, ini adalah pilihan yang lebih baik untuk type-safety dan decoupling.

        Meskipun Component adalah superclass yang baik, ia tidak membedakan fungsionalitas.

        Solusi: Seharusnya ada marker interface seperti interface Storage dan interface Peripheral.

        Dengan menggunakan interface, Anda dapat mengubah PC.java menjadi private List<Storage> storageDevices;. Ini akan membuat kode jauh lebih aman karena kompiler akan mencegah Anda secara tidak sengaja menambahkan Mouse ke daftar storageDevices (masalah validasi di poin 3).

2. Pelanggaran Enkapsulasi

Kritik Enkapsulasi:

    Tidak ada pelanggaran enkapsulasi yang serius.

        Fields name dan price di Component.java dideklarasikan sebagai protected, bukan public. Ini berarti hanya subclass (misalnya Ssd, Cpu) yang dapat mengaksesnya secara langsung, dan class luar (seperti PC atau Main) harus menggunakan getter (getName(), getPrice()).

        Ini adalah praktik yang baik. Anda telah berhasil menjaga state internal class terlindungi dari modifikasi langsung dari luar.

3. Kurangnya Validasi (Invalid State)

Kritik Validasi: Ya, terdapat kekurangan validasi yang signifikan, yang memungkinkan pembuatan state PC yang tidak valid.
Masalah Validasi	Detail
Tidak ada Type Safety (Kelemahan Arsitektur)	Metode addStorage(Component storage) menerima semua objek yang merupakan Component. Secara teknis, Anda dapat menambahkan objek Mouse atau Keyboard ke dalam daftar storageDevices. Ini adalah state yang tidak valid untuk sebuah PC dan merupakan kegagalan validasi jenis.
Keterbatasan RAM (Design Flaw)	

Anda menggunakan private Component ram; (sebuah field tunggal) di PC.java. Ini secara efektif membatasi PC hanya memiliki satu stick RAM, padahal PC modern biasanya memiliki 2 atau 4 slot RAM untuk dual-channel atau quad-channel. Desain ini mencegah implementasi validasi yang realistis (misalnya, melarang 5 stick RAM, atau melarang total kapasitas melebihi batas motherboard).

Tidak Ada Kompatibilitas	

Sebagai aplikasi Konfigurator PC, tidak ada validasi fundamental seperti: Apakah CPU kompatibel dengan socket Motherboard? Meskipun ini adalah tugas yang rumit, ketiadaan logika validasi kompatibilitas membuat aplikasi belum memenuhi syarat sebagai "Konfigurator PC" sejati.

4. Sisa Code Smell

Kritik Code Smell:

    Feature Envy: Sudah Terselesaikan. Dengan mengasumsikan Anda telah berhasil memindahkan method generateReport() dari PCReportGenerator.java ke PC.java (sesuai Misi 2 ), code smell utama ini sudah dihilangkan.

Method Complexity/Long Method:

    Metode getComponent(String name) dan checkComponentType(Component component) di PC.java harus melakukan pencarian dan perbandingan melalui komponen inti (motherboard, cpu, ram) dan dua list (storageDevices, peripherals).

    Kritik: Metode ini melanggar prinsip Tell, Don't Ask. Daripada PC sendiri yang sibuk mencari di mana letak komponen, lebih baik jika logika pencarian didelegasikan atau dipecah. Namun, untuk skala proyek ini, metodenya masih dapat diterima (tidak terlalu panjang atau rumit).
