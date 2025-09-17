# Proyek E-Commerce Konsol (Polban)

Sebuah aplikasi konsol sederhana yang mensimulasikan fungsionalitas dasar dari sebuah sistem E-Commerce. Proyek ini dibuat sebagai implementasi dari konsep-konsep fundamental **Pemrograman Berorientasi Objek (PBO)**, termasuk pewarisan, polimorfisme, dan enkapsulasi.

---

## 📋 Fitur Utama

-   **Manajemen Produk**: Menambah dan mengelola daftar produk yang tersedia.
-   **Simulasi Belanja**: Pengguna dapat memilih produk dan menambahkannya ke keranjang belanja (`Cart`).
-   **Proses Transaksi**: Menghitung total belanja dan membuat pesanan (`Order`).
-   **Hirarki Produk**: Mengimplementasikan struktur kelas yang logis untuk berbagai jenis produk (Pakaian, Makanan, dll.) untuk menunjukkan konsep pewarisan.
-   **Tampilan Detail Dinamis**: Menampilkan detail yang berbeda untuk setiap jenis produk menggunakan metode yang sama (`displayDetails()`), yang merupakan contoh polimorfisme.

---

## 📂 Struktur Proyek

Proyek ini disusun menggunakan struktur paket (`package`) untuk memisahkan antara model data dan logika bisnis.

-   **`id.ac.polban.ecommerce.model`**: Berisi semua kelas yang merepresentasikan entitas data (objek).
    -   `Product.java`: Kelas induk untuk semua produk.
    -   `ApparelProduct.java` & `FoodProduct.java`: Turunan dari `Product` untuk kategori spesifik.
    -   `ShirtProduct.java`, `PantsProduct.java`, `BeverageProduct.java`: Turunan yang lebih spesifik lagi.
    -   `Customer.java`, `Cart.java`, `Order.java`: Kelas-kelas lain yang mendukung proses bisnis.
-   **`id.ac.polban.ecommerce.service`**: Berisi kelas yang menangani logika bisnis.
    -   `ECommerceService.java`: Mengelola daftar produk dan memproses transaksi.
-   **`App.java`**: Kelas utama yang berisi metode `main` untuk menjalankan aplikasi.

---

## 💡 Implementasi Konsep PBO

Proyek ini secara aktif menerapkan pilar-pilar utama PBO:

### 1. Pewarisan (Inheritance)

Konsep ini diimplementasikan melalui hirarki kelas `Product`.
-   `Product` bertindak sebagai `superclass` dengan atribut umum (`id`, `nama`, `harga`).
-   `ApparelProduct` dan `FoodProduct` bertindak sebagai `subclass` yang `extends Product` dan menambahkan atributnya sendiri.
-   Hirarki ini berlanjut ke level tiga dengan kelas seperti `ShirtProduct` yang `extends ApparelProduct`.

### 2. Polimorfisme (Melalui Method Overriding)

Setiap kelas dalam hirarki produk meng-*override* metode `displayDetails()`. Hal ini memungkinkan kita memanggil metode yang sama pada objek yang berbeda dan mendapatkan output yang sesuai dengan tipe spesifik objek tersebut.

```java
// Contoh Polimorfisme
Product[] allProducts = {shirt, pants, coffee};
for (Product p : allProducts) {
    p.displayDetails(); // Memanggil versi metode yang berbeda tergantung objeknya
    System.out.println("---");
}
3. Enkapsulasi
Atribut di setiap kelas dideklarasikan sebagai private dan hanya bisa diakses melalui metode publik (getter dan setter). Ini memastikan integritas data dan menyembunyikan detail implementasi internal dari dunia luar.

🚀 Cara Menjalankan
Aplikasi ini dapat dijalankan melalui IDE atau langsung dari terminal setelah dikemas menjadi file JAR.

1. Melalui IDE (Contoh: VS Code, IntelliJ)
Buka proyek di IDE Anda.

Temukan file App.java (atau AppHierarchyTestComplex.java untuk pengujian hirarki).

Klik kanan pada file tersebut dan pilih "Run Java".

2. Melalui Terminal (Menggunakan JAR)
Proyek ini dapat dikemas ke dalam sebuah file .jar yang dapat dieksekusi.

Kompilasi Proyek:
Navigasi ke direktori utama proyek dan jalankan perintah kompilasi. Pastikan untuk menyertakan semua file .java.

Buat Manifest File (MANIFEST.MF):
Buat file teks dengan isi berikut untuk menunjuk kelas utama:

Main-Class: App
Buat File JAR:
Gunakan perintah jar untuk mengemas semua file .class dan manifest.

Bash

jar cvfm polban-ecommerce.jar MANIFEST.MF -C build/classes .
Jalankan Aplikasi:
Setelah file polban-ecommerce.jar dibuat, jalankan dengan perintah:

Bash

java -jar polban-ecommerce.jar
Diagram Hirarki Kelas
Berikut adalah visualisasi dari struktur pewarisan kelas produk yang diimplementasikan.

Cuplikan kode

classDiagram
    direction TD

    class Product {
        +int idProduk
        +String namaProduk
        +double harga
        +displayDetails()
    }

    class ApparelProduct {
        +String size
        +String color
        +displayDetails()
    }

    class FoodProduct {
        +LocalDate expirationDate
        +displayDetails()
    }

    class ShirtProduct {
        +String sleeveType
        +displayDetails()
    }

    class PantsProduct {
        +String pantsType
        +int waistSize
        +displayDetails()
    }

    class BeverageProduct {
        +int volumeMl
        +displayDetails()
    }

    Product <|-- ApparelProduct
    Product <|-- FoodProduct
    ApparelProduct <|-- ShirtProduct
    ApparelProduct <|-- PantsProduct
    FoodProduct <|-- BeverageProduct
