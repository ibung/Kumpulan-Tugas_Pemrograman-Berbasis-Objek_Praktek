# E-commerce Java Application

Aplikasi e-commerce sederhana yang dibangun dengan Java untuk pembelajaran Object-Oriented Programming.

## 📋 System Requirements

- Java 17 atau lebih tinggi
- RAM minimum 512MB
- Disk space 50MB

## 🚀 Cara Menjalankan

### Compile dan Run
```bash
# 1. Pindah ke root project
cd e-commerce

# 2. Compile semua file
javac -d bin src/App.java src/id/ac/polban/ecommerce/model/*.java src/id/ac/polban/ecommerce/service/*.java

# 3. Jalankan aplikasi
java -cp bin App
```

### Menggunakan JAR (jika tersedia)
```bash
java -jar lib/ecommerce.jar
```

## 🛍️ Fitur Utama

- Input data pelanggan
- Browse katalog produk
- Tambah produk ke keranjang
- Validasi stok otomatis
- Checkout dan generate invoice
- Tampilan yang user-friendly

## 📁 Struktur Project

```
e-commerce/
├── src/
│   ├── App.java                                    # Main application
│   └── id/ac/polban/ecommerce/
│       ├── model/
│       │   ├── Cart.java                          # Shopping cart
│       │   ├── Customer.java                      # Customer data
│       │   ├── Order.java                         # Order processing
│       │   └── Product.java                       # Product model
│       └── service/
│           └── ECommerceService.java              # Business logic
├── bin/                                           # Compiled classes
├── lib/                                           # JAR files
├── ProjectBaru/                                   # Tugas
├── .vscode/                                          
├── README.md
└── dll
```

## 💡 Cara Menggunakan

1. **Jalankan aplikasi** dengan perintah di atas
2. **Masukkan data pelanggan** (nama, email, alamat, no HP)
3. **Pilih produk** dari katalog yang tersedia
4. **Tentukan jumlah** produk yang ingin dibeli
5. **Lanjut berbelanja** atau checkout
6. **Lihat invoice** pembelian lengkap

## 🔧 Troubleshooting

### Error: Could not find or load main class
**Solusi:** Pastikan menjalankan `java App` dari direktori yang benar dan sudah compile semua file.

### Error: Versi Java tidak kompatibel
**Solusi:** Update Java ke versi 17+ atau compile ulang dengan versi Java yang sama.

### Error: File tidak ditemukan
**Solusi:** Pastikan struktur folder sesuai dan jalankan dari root project.

## 🎓 Learning Objectives

- Implementasi konsep OOP (Class, Object, Encapsulation)
- Relasi antar kelas (Dependency, Aggregation, Composition)
- Package management dan struktur project
- Input validation dan error handling
- Business logic dalam aplikasi nyata

## 👨‍💻 Author

Dibuat untuk pembelajaran mata kuliah Pemrograman Berorientasi Objek - Politeknik Negeri Bandung

## 📄 License

Project ini dibuat untuk keperluan edukasi.
