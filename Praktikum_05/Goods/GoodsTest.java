/**
 * Kelas utama untuk demonstrasi implementasi Goods Hierarchy
 */
public class GoodsTest {
    
    public static void main(String[] args) {
        System.out.println("====== DEMO IMPLEMENTASI HIERARKI BARANG ======\n");
        
        // Membuat objek dari setiap kelas
        Food apel = new Food("Apel Merah Segar", 12500, 95);
        Food pizza = new Food("Pizza Margherita", 65000, 320);
        
        Toy lego = new Toy("Set Balok LEGO", 250000, 6);
        Toy boneka = new Toy("Boneka Teddy Bear", 78000, 1);
        
        Book bukuJava = new Book("Panduan Pemrograman Java", 85000, "Ibnu Hilmi");
        Book bukuPython = new Book("Python untuk Pemula", 62000, "Hityam Khaeru");
        
        // Menampilkan informasi setiap objek
        System.out.println("====== INFORMASI OBJEK INDIVIDUAL ======\n");
        
        apel.display();
        System.out.println("Sehat? " + (apel.isHealthy() ? "Ya" : "Tidak"));
        System.out.println();
        
        pizza.display();
        System.out.println("Sehat? " + (pizza.isHealthy() ? "Ya" : "Tidak"));
        System.out.println();
        
        lego.display();
        System.out.println("Aman untuk usia 5 tahun? " + (lego.isSafeForAge(5) ? "Ya" : "Tidak"));
        System.out.println("Untuk balita? " + (lego.isForToddlers() ? "Ya" : "Tidak"));
        System.out.println();
        
        boneka.display();
        System.out.println("Aman untuk usia 2 tahun? " + (boneka.isSafeForAge(2) ? "Ya" : "Tidak"));
        System.out.println("Untuk balita? " + (boneka.isForToddlers() ? "Ya" : "Tidak"));
        System.out.println();
        
        bukuJava.display();
        System.out.println("Info lengkap: " + bukuJava.getFullBookInfo());
        System.out.println("Mahal? " + (bukuJava.isExpensive() ? "Ya" : "Tidak"));
        System.out.println();
        
        bukuPython.display();
        System.out.println("Info lengkap: " + bukuPython.getFullBookInfo());
        System.out.println("Mahal? " + (bukuPython.isExpensive() ? "Ya" : "Tidak"));
        System.out.println();
        
        // Demonstrasi polymorphism
        System.out.println("====== DEMONSTRASI POLYMORPHISM ======\n");
        Goods[] daftarBarang = {apel, pizza, lego, boneka, bukuJava, bukuPython};
        
        double totalHarga = 0;
        double totalPajak = 0;
        int barangKenaPajak = 0;
        int barangBebasPajak = 0;
        
        for (int i = 0; i < daftarBarang.length; i++) {
            System.out.println("Barang " + (i + 1) + ":");
            daftarBarang[i].display();
            totalHarga += daftarBarang[i].getPrice();
            
            if (daftarBarang[i] instanceof Taxable) {
                double pajak = ((Taxable) daftarBarang[i]).calculateTax();
                totalPajak += pajak;
                barangKenaPajak++;
                System.out.println("✓ Barang ini kena pajak");
            } else {
                barangBebasPajak++;
                System.out.println("✗ Barang ini bebas pajak");
            }
            System.out.println("---\n");
        }
        
        // Demonstrasi interface
        System.out.println("====== DEMONSTRASI INTERFACE TAXABLE ======\n");
        System.out.println("Memproses hanya barang yang kena pajak...\n");
        
        for (Goods barang : daftarBarang) {
            if (barang instanceof Taxable) {
                Taxable barangKenaPajakObj = (Taxable) barang;
                System.out.println("Memproses: " + barang.getDescription());
                System.out.println("Harga dasar: Rp" + String.format("%.2f", barang.getPrice()));
                System.out.println("Pajak: Rp" + String.format("%.2f", barangKenaPajakObj.calculateTax()));
                System.out.println("---");
            }
        }
        
        // Ringkasan keranjang belanja
        System.out.println("\n====== RINGKASAN KERANJANG BELANJA ======");
        System.out.println("Total barang: " + daftarBarang.length);
        System.out.println("Barang kena pajak: " + barangKenaPajak);
        System.out.println("Barang bebas pajak: " + barangBebasPajak);
        System.out.println("Subtotal: Rp" + String.format("%.2f", totalHarga));
        System.out.println("Total pajak: Rp" + String.format("%.2f", totalPajak));
        System.out.println("Total keseluruhan: Rp" + String.format("%.2f", (totalHarga + totalPajak)));
        System.out.println("Rata-rata tarif pajak: " + String.format("%.2f", (totalPajak/totalHarga)*100) + "%");
        
        System.out.println("\n====== DEMO SELESAI ======");
    }
}