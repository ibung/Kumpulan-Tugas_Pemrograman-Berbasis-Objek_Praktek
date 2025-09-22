# Latihan Praktikum PBO: Pewarisan dan Hirarki Kelas

Repositori ini berisi implementasi kode untuk tiga latihan praktikum yang mencakup konsep-konsep fundamental Pemrograman Berorientasi Objek (PBO), khususnya **Pewarisan (Inheritance)**.

---

##  Latihan 1: Pewarisan Dasar (`Circle` dan `Cylinder`)

Latihan ini memperkenalkan konsep pewarisan paling dasar dengan membuat kelas `Cylinder` sebagai turunan (`subclass`) dari `Circle` (`superclass`).

**Konsep yang dipelajari:**
-   Penggunaan kata kunci `extends` untuk menciptakan hubungan pewarisan.
-   Pemanggilan konstruktor dan metode dari kelas induk menggunakan `super`.
-   Mengubah perilaku metode warisan dengan `@Override`.

---

##  Latihan 2: Hirarki Kelas (`Shape` dan Turunannya)

Latihan ini mengembangkan konsep pewarisan ke dalam sebuah hirarki yang lebih terstruktur dan bertingkat.

**Struktur Hirarki:**
1.  **Level 1:** `Shape` (Kelas Induk)
2.  **Level 2:** `Circle` dan `Rectangle` (Turunan dari `Shape`)
3.  **Level 3:** `Square` (Turunan dari `Rectangle`)

Latihan ini menunjukkan bagaimana sebuah kelas bisa menjadi induk bagi banyak kelas anak, dan bagaimana pewarisan bisa terjadi lebih dari satu tingkat.

---

##  Latihan 3: Studi Kasus - Hirarki Produk E-Commerce

Latihan ini merupakan penerapan praktis dari semua konsep yang telah dipelajari ke dalam sebuah proyek E-Commerce. Sebuah hirarki produk yang logis dan kompleks dibuat untuk mengelola berbagai jenis barang.

**Struktur Hirarki:**
-   **Level 1:** `Product`
-   **Level 2:** `ApparelProduct` dan `FoodProduct`
-   **Level 3:** `ShirtProduct`, `PantsProduct`, dan `BeverageProduct`

Tugas ini menunjukkan bagaimana merancang struktur kelas yang baik dan logis untuk aplikasi dunia nyata, di mana setiap jenis produk memiliki detailnya sendiri namun tetap mewarisi sifat-sifat umum dari produk dasar.
