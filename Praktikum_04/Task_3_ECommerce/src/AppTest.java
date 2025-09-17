import id.ac.polban.ecommerce.model.*;

public class AppTest {
    public static void main(String[] args) {
        // Membuat objek dari setiap cabang dan tingkatan
        ShirtProduct shirt = new ShirtProduct(502, "Kemeja Flanel", 275000, "L", "Merah Kotak-kotak", "Lengan Panjang");
        
        // Menambahkan objek baru dari kelas PantsProduct
        PantsProduct pants = new PantsProduct(401, "Celana Jeans Slim-Fit", 450000, "L", "Biru Dongker", "Jeans", 32);
        
        BeverageProduct coffee = new BeverageProduct(601, "Kopi Kaleng Siap Minum", 15000, "2026-12-31", 250);

        System.out.println("--- Detail Kemeja (Level 3 dari Apparel) ---");
        shirt.displayDetails();
        System.out.println("\n--------------------------------------------\n");

        System.out.println("--- Detail Celana (Level 3 dari Apparel) ---"); // Bagian baru
        pants.displayDetails();
        System.out.println("\n--------------------------------------------\n");
        
        System.out.println("--- Detail Minuman (Level 3 dari Makanan) ---");
        coffee.displayDetails();
        System.out.println("\n--------------------------------------------\n");

        // Contoh Polimorfisme: Menyimpan semua objek dalam array superclass
        System.out.println("--- Menampilkan semua sebagai 'Product' ---");
        // Memasukkan objek baru ke dalam array
        Product[] allProducts = {shirt, pants, coffee};
        for (Product p : allProducts) {
            p.displayDetails();
            System.out.println("---");
        }
    }
}