import id.ac.polban.ecommerce.model.*;
import id.ac.polban.ecommerce.service.ECommerceService;
import java.util.Scanner;

public class App {
    private static ECommerceService ecommerceService;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize
        ecommerceService = new ECommerceService();
        scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              SELAMAT DATANG DI POLBAN E-COMMERCE               ║");
        System.out.println("║                   Sistem Pembelian Online                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        try {
            // Step 1: Input data pelanggan
            Customer customer = inputCustomerData();
            
            // Step 2: Shopping - pilih barang
            Cart cart = doShopping();
            
            // Step 3: Process transaction dan tampilkan output
            ecommerceService.processTransaction(customer, cart);
            
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        System.out.println("\nProgram selesai. Terima kasih!");
    }
    
    private static Customer inputCustomerData() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                     INPUT DATA PELANGGAN                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        System.out.print("Masukkan nama lengkap    : ");
        String nama = scanner.nextLine().trim();
        
        System.out.print("Masukkan email           : ");
        String email = scanner.nextLine().trim();
        
        System.out.print("Masukkan alamat lengkap  : ");
        String alamat = scanner.nextLine().trim();
        
        System.out.print("Masukkan nomor HP        : ");
        String noHP = scanner.nextLine().trim();
        
        Customer customer = new Customer(1, nama, email, alamat, noHP);
        
        System.out.println("\n  Data pelanggan berhasil disimpan!");
        System.out.println("  Nama   : " + customer.getNama());
        System.out.println("  Email  : " + customer.getEmail());
        System.out.println("  Alamat : " + customer.getAlamat());
        System.out.println("  No HP  : " + customer.getFormattedNoHP());
        
        return customer;
    }
    
    private static Cart doShopping() {
        Cart cart = new Cart(1);
        
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        MULAI BERBELANJA                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        boolean continueShopping = true;
        
        while (continueShopping) {
            // Display products
            ecommerceService.displayProducts();
            
            // Display current cart if not empty
            if (cart.getJumlahProduk() > 0) {
                displayCurrentCart(cart);
            }
            
            System.out.print("\nMasukkan ID produk yang ingin dibeli (0 untuk selesai): ");
            
            try {
                int productId = Integer.parseInt(scanner.nextLine().trim());
                
                if (productId == 0) {
                    if (cart.getJumlahProduk() == 0) {
                        System.out.println("Anda belum memilih produk apapun!");
                        System.out.print("Apakah Anda yakin ingin keluar? (y/n): ");
                        String confirm = scanner.nextLine().trim();
                        if (confirm.equalsIgnoreCase("y")) {
                            System.out.println("Terima kasih! Program dihentikan.");
                            System.exit(0);
                        }
                        continue;
                    }
                    continueShopping = false;
                    continue;
                }
                
                Product product = ecommerceService.findProductById(productId);
                if (product == null) {
                    System.out.println("Produk dengan ID " + productId + " tidak ditemukan!");
                    continue;
                }
                
                System.out.println("Produk dipilih: " + ecommerceService.getProductInfo(productId));
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                
                int quantity = Integer.parseInt(scanner.nextLine().trim());
                
                if (quantity <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    continue;
                }
                
                /*if (!ecommerceService.hasEnoughStock(productId, quantity)) {
                    System.out.println("Stok tidak mencukupi! Stok tersedia: " + product.getStok());
                    continue;
                }
                */
                
                // Add products to cart based on quantity
                for (int i = 0; i < quantity; i++) {
                    cart.tambahProduk(product);
                }
                
                System.out.println("Berhasil menambahkan " + quantity + " " + product.getNamaProduk() + " ke keranjang!");
                
                System.out.print("\nLanjut berbelanja? (y/n): ");
                String lanjut = scanner.nextLine().trim();
                if (lanjut.equalsIgnoreCase("n")) {
                    continueShopping = false;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
        
        return cart;
    }
    
    private static void displayCurrentCart(Cart cart) {
        System.out.println("\n┌────────────────────────────────────────────────────────────────┐");
        System.out.println("│                       KERANJANG BELANJA                        │");
        System.out.println("├────────────────────────────────────────────────────────────────┤");
        
        // Count quantities for each unique product
        java.util.HashMap<Integer, Integer> productCount = new java.util.HashMap<>();
        java.util.HashMap<Integer, Product> productMap = new java.util.HashMap<>();
        
        for (Product product : cart.getDaftarProduk()) {
            int id = product.getIdProduk();
            productCount.put(id, productCount.getOrDefault(id, 0) + 1);
            productMap.put(id, product);
        }
        
        System.out.printf("│ %-25s %-12s %-6s %-15s │\n", "Produk", "Harga", "Qty", "Subtotal");
        System.out.println("├────────────────────────────────────────────────────────────────┤");
        
        for (java.util.Map.Entry<Integer, Integer> entry : productCount.entrySet()) {
            Product product = productMap.get(entry.getKey());
            int qty = entry.getValue();
            double subtotal = product.getHarga() * qty;
            
            System.out.printf("│ %-25s Rp %-9.0f %-6d Rp %-12.0f │\n", 
                product.getNamaProduk(), 
                product.getHarga(), 
                qty, 
                subtotal);
        }
        System.out.println("├────────────────────────────────────────────────────────────────┤");
        System.out.printf("│ %-46s Rp %-12.0f │\n", "TOTAL:", cart.hitungTotalHarga());
        System.out.println("└────────────────────────────────────────────────────────────────┘");
    }
}