# 📚 Praktikum PBO - Implementasi Inheritance dan Abstract Class

> **Mata Kuliah:** Pemrograman Berbasis Objek (Praktek)  
> **Topik:** Inheritance, Interface, Abstract Class, dan Polymorphism  
> **Semester:** Genap 2024/2025

## 🎯 Overview

Repository ini berisi implementasi dua studi kasus berbeda untuk memahami konsep fundamental Object-Oriented Programming (OOP) dalam Java:

1. **Goods Hierarchy** - Implementasi interface dan inheritance dengan sistem produk
2. **Sortable Employee** - Implementasi abstract class dengan algoritma sorting

## 🏗️ Struktur Project

```
📦 praktikum-pbo-inheritance/
├── 📁 goods-hierarchy/
│   ├── 📄 Taxable.java
│   ├── 📄 Goods.java
│   ├── 📄 Food.java
│   ├── 📄 Toy.java
│   ├── 📄 Book.java
│   └── 📄 GoodsHierarchyDemo.java
├── 📁 sortable-employee/
│   ├── 📄 Sortable.java
│   ├── 📄 Employee.java
│   ├── 📄 Manager.java
│   └── 📄 EmployeeTest.java
├── 📄 README.md
└── 📄 Laporan_Praktikum.md
```

## 🚀 Quick Start

### Prerequisites
- Java JDK 8 atau lebih tinggi
- Terminal/Command Prompt
- Text Editor atau IDE (VS Code, IntelliJ, Eclipse)

### Installation & Setup

```bash
# Clone repository
git clone <repository-url>
cd praktikum-pbo-inheritance

# Atau download dan extract ZIP file
```

### Running the Projects

#### 1️⃣ Goods Hierarchy
```bash
# Navigate ke folder
cd goods-hierarchy/

# Compile semua file
javac *.java

# Run demo
java GoodsHierarchyDemo
```

#### 2️⃣ Sortable Employee
```bash
# Navigate ke folder
cd sortable-employee/

# Compile semua file
javac *.java

# Run test
java EmployeeTest
```

## 📋 Project Details

### 🛍️ Goods Hierarchy Implementation

**Konsep yang Dipraktikkan:**
- ✅ Interface implementation (`Taxable`)
- ✅ Inheritance dengan `extends`
- ✅ Method overriding dengan `@Override`
- ✅ Polymorphism dan runtime dispatch
- ✅ Encapsulation dengan access modifiers

**Class Structure:**
```
Interface Taxable
    ├── TAX_RATE: double (6%)
    └── calculateTax(): double

Class Goods (Parent)
    ├── description: String
    ├── price: double
    └── display(): void

├── Class Food extends Goods
│   ├── calories: int
│   ├── isHealthy(): boolean
│   └── [Tidak implements Taxable]
│
├── Class Toy extends Goods implements Taxable
│   ├── minimumAge: int
│   ├── isForToddlers(): boolean
│   └── isSafeForAge(int): boolean
│
└── Class Book extends Goods implements Taxable
    ├── author: String
    ├── isExpensive(): boolean
    └── isByAuthor(String): boolean
```

**Sample Output:**
```
====== DEMO IMPLEMENTASI HIERARKI BARANG ======

=== Informasi Makanan ===
Deskripsi: Apel Merah Segar
Harga: Rp12.500,00
Kalori: 95
Status: Bebas pajak

=== Informasi Mainan ===
Deskripsi: Set Balok LEGO
Harga: Rp250.000,00
Usia minimum: 6 tahun
Tarif pajak: 6.0%
Jumlah pajak: Rp15.000,00
Total harga: Rp265.000,00
```

### 👥 Sortable Employee Implementation

**Konsep yang Dipraktikkan:**
- ✅ Abstract class dengan abstract method
- ✅ Static method dalam abstract class
- ✅ Inheritance bertingkat (Manager → Employee → Sortable)
- ✅ Shell Sort algorithm implementation
- ✅ Custom comparison logic

**Class Structure:**
```
Abstract Class Sortable
    ├── compare(Sortable): int [abstract]
    └── shell_sort(Sortable[]): void [static]

Class Employee extends Sortable
    ├── name: String
    ├── salary: double
    ├── day, month, year: int
    └── compare(): int [by salary]

Class Manager extends Employee
    ├── department: String
    ├── bonus: double
    ├── getTotalSalary(): double
    └── compare(): int [by total salary]
```

**Algorithm Details:**
- **Shell Sort** dengan kompleksitas O(n log n)
- Gap reduction: n/2 → n/4 → n/8 → ... → 1
- Generic implementation untuk semua Sortable objects

**Sample Output:**
```
=== CASE 1: EMPLOYEE SORTING ===

Data Employee sebelum diurutkan:
1. Nama: Antonio Rossi, Gaji: Rp2.000.000, Tanggal Lahir: 1/10/1989
2. Nama: Maria Bianchi, Gaji: Rp2.500.000, Tanggal Lahir: 1/12/1991

Data Employee setelah diurutkan berdasarkan gaji:
1. Nama: John Smith, Gaji: Rp1.800.000, Tanggal Lahir: 15/5/1987
2. Nama: Antonio Rossi, Gaji: Rp2.000.000, Tanggal Lahir: 1/10/1989
```

## 🎨 Features

### 🌟 Key Features
- **Modular Design** - Setiap class memiliki tanggung jawab yang jelas
- **Input Validation** - Validasi semua setter methods
- **Comprehensive Testing** - Demo lengkap untuk setiap fitur
- **Indonesian Localization** - Output dalam bahasa Indonesia
- **Error Handling** - Proper exception handling dan validation
- **Documentation** - Code comments dan JavaDoc style

### 🔍 Advanced Features
- **Polymorphism Demo** - Array campuran dengan type checking
- **Method Chaining** - Fluent interface pada beberapa method
- **Currency Formatting** - Format Rupiah yang konsisten
- **Algorithm Visualization** - Step-by-step sorting process
- **Type Safety** - Proper instanceof checking

## 📚 Learning Objectives

### 🎯 Dari Goods Hierarchy:
- [x] Memahami perbedaan Interface vs Abstract Class
- [x] Implementasi selective interface (tidak semua subclass implement)
- [x] Method overriding untuk customization
- [x] Polymorphism dalam praktik nyata
- [x] Design pattern untuk sistem e-commerce

### 🎯 Dari Sortable Employee:
- [x] Abstract class sebagai template method pattern
- [x] Static method dalam abstract class
- [x] Inheritance bertingkat yang logis
- [x] Algorithm implementation dengan generic approach
- [x] Custom comparison logic untuk different object types

## 🛠️ Development

### Code Style
- **Naming Convention:** camelCase untuk variables/methods, PascalCase untuk classes
- **Language:** Class names dan method names dalam English, output text dalam Indonesian
- **Comments:** Minimal namun informatif, fokus pada penjelasan logic
- **Formatting:** Consistent indentation dan spacing

### Best Practices
- ✅ Single Responsibility Principle
- ✅ Open/Closed Principle  
- ✅ Proper encapsulation
- ✅ Input validation
- ✅ Error handling
- ✅ Code reusability

## 🐛 Common Issues & Solutions

### Compilation Issues
```bash
# Jika ada error "class not found"
javac *.java

# Jika package error
# Pastikan tidak ada package declaration di file
```

### Runtime Issues
```bash
# Jika ClassCastException
# Check instanceof sebelum casting

# Jika NullPointerException  
# Validate input pada setter methods
```

### Performance
- Shell Sort optimal untuk dataset medium (100-10000 elements)
- Untuk dataset besar, consider QuickSort atau MergeSort
- Interface method calls memiliki slight overhead vs direct calls

## 📖 References & Further Reading

### 📚 Concept References
- [Oracle Java Tutorials - Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Oracle Java Tutorials - Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Oracle Java Tutorials - Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

### 🔍 Algorithm References  
- [Shell Sort Algorithm](https://en.wikipedia.org/wiki/Shellsort)
- [Comparison-based Sorting](https://en.wikipedia.org/wiki/Comparison_sort)

### 🎯 Design Pattern References
- [Template Method Pattern](https://refactoring.guru/design-patterns/template-method)
- [Strategy Pattern](https://refactoring.guru/design-patterns/strategy)

## 🤝 Contributing

Jika ingin berkontribusi pada project ini:

1. Fork repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📝 License

Project ini dibuat untuk keperluan pembelajaran mata kuliah PBO.  
**Educational Use Only** - Tidak untuk keperluan komersial.

## 👨‍💻 Author

**Ibnu Hilmi Athaillah** - 241511079  
📧 Email: ibnupisces08@gmail.com
🎓 D-3 Teknik Informatika, Politeknik Negeri Bandung

---

### 📈 Project Stats

- **Lines of Code:** ~800+ lines
- **Classes Created:** 9 classes + 2 interfaces/abstract classes  
- **Design Patterns:** Template Method, Strategy
- **Algorithms:** Shell Sort (O(n log n))
- **Test Cases:** 15+ different scenarios

### 🏆 Achievement Unlocked
- ✅ Master Inheritance & Polymorphism
- ✅ Implement Interface & Abstract Class  
- ✅ Algorithm Implementation Expert
- ✅ Java OOP Specialist
- ✅ Clean Code Practitioner

---

**Happy Coding! 🚀**

> *"Object-oriented programming is not just a programming paradigm, it's a way of thinking about problems."*
