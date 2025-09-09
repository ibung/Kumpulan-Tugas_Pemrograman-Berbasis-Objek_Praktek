package id.ac.polban.ecommerce.service;

import id.ac.polban.ecommerce.model.*;
import java.util.ArrayList;
import java.util.List;

public class ECommerceService {
    
    // Data storage
    private ArrayList<Product> products;
    private int nextProductId = 1;
    
    // Constructor
    public ECommerceService() {
        products = new ArrayList<>();
        initializeSampleData();
    }
    
    // Initialize sample data
    private void initializeSampleData() {
        addProduct("Laptop ASUS ROG", 25000000.0, 5);
        addProduct("Mouse Gaming Logitech", 350000.0, 20);
        addProduct("Keyboard Mechanical RGB", 1200000.0, 15);
        addProduct("Monitor Gaming 27\"", 4500000.0, 8);
        addProduct("Webcam 4K", 800000.0, 12);
        addProduct("Headset Gaming", 650000.0, 18);
        addProduct("SSD 1TB", 1800000.0, 10);
        addProduct("RAM 16GB DDR4", 900000.0, 25);
    }
    
    public Product addProduct(String nama, double harga, int stok) {
        Product product = new Product(nextProductId++, nama, harga, stok);
        products.add(product);
        return product;
    }
    
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getIdProduk() == id) {
                return product;
            }
        }
        return null;
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    // Display products dalam format yang tidak menampilkan stok eksplisit
    public void displayProducts() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                    DAFTAR PRODUK TERSEDIA");
        System.out.println("=".repeat(70));
        System.out.printf("%-4s %-25s %-15s %-10s\n", "ID", "Nama Produk", "Harga", "Status");
        System.out.println("-".repeat(70));
        
        for (Product product : products) {
            String status = product.isAvailable() ? "Tersedia" : "Habis";
            System.out.printf("%-4d %-25s Rp %-12.0f %-10s\n", 
                product.getIdProduk(), 
                product.getNamaProduk(), 
                product.getHarga(), 
                status);
        }
        System.out.println("=".repeat(70));
    }
    
    // Method untuk admin/system mengecek stok internal (protected access)
    protected int getInternalStockCount(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            // Menggunakan reflection atau method khusus untuk mengakses stok internal
            try {
                java.lang.reflect.Method method = Product.class.getDeclaredMethod("getInternalInventoryCount");
                method.setAccessible(true);
                return (Integer) method.invoke(product);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
    
    // Process complete transaction
    public void processTransaction(Customer customer, Cart cart) {
        if (cart.getDaftarProduk().isEmpty()) {
            System.out.println("Tidak ada produk dalam keranjang!");
            return;
        }
        
        // Create order
        Order order = new Order(1, cart.hitungTotalHarga(), "Completed");
        
        // Reduce stock for each product in cart
        for (Product product : cart.getDaftarProduk()) {
            // Find the actual product in inventory and reduce stock
            Product inventoryProduct = findProductById(product.getIdProduk());
            if (inventoryProduct != null) {
                inventoryProduct.kurangiStok(1);
            }
        }
        
        // Display complete transaction summary
        displayTransactionSummary(customer, cart, order);
    }
    
    private void displayTransactionSummary(Customer customer, Cart cart, Order order) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                           INVOICE PEMBELIAN");
        System.out.println("                         POLBAN E-COMMERCE STORE");
        System.out.println("=".repeat(80));
        
        // Customer Info
        System.out.println("INFORMASI PELANGGAN:");
        System.out.println("Nama     : " + customer.getNama());
        System.out.println("Email    : " + customer.getEmail());
        System.out.println("Alamat   : " + customer.getAlamat());
        System.out.println("No. HP   : " + customer.getFormattedNoHP());
        
        System.out.println("\n" + "-".repeat(80));
        
        // Order Info
        System.out.println("INFORMASI PESANAN:");
        System.out.println("Order ID        : " + order.getIdOrder());
        System.out.println("Tanggal Order   : " + order.getTanggalOrder());
        System.out.println("Status          : " + order.getStatus());
        
        System.out.println("\n" + "-".repeat(80));
        
        // Product Details
        System.out.println("DETAIL PRODUK:");
        System.out.printf("%-4s %-30s %-15s %-10s %-15s\n", 
            "No", "Nama Produk", "Harga Satuan", "Qty", "Subtotal");
        System.out.println("-".repeat(80));
        
        // Count quantities for each unique product
        ArrayList<Product> uniqueProducts = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        
        for (Product product : cart.getDaftarProduk()) {
            int index = -1;
            for (int i = 0; i < uniqueProducts.size(); i++) {
                if (uniqueProducts.get(i).getIdProduk() == product.getIdProduk()) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) {
                uniqueProducts.add(product);
                quantities.add(1);
            } else {
                quantities.set(index, quantities.get(index) + 1);
            }
        }
        
        int itemNo = 1;
        for (int i = 0; i < uniqueProducts.size(); i++) {
            Product product = uniqueProducts.get(i);
            int qty = quantities.get(i);
            double subtotal = product.getHarga() * qty;
            
            System.out.printf("%-4d %-30s Rp %-12.0f %-10d Rp %-12.0f\n", 
                itemNo++, 
                product.getNamaProduk(), 
                product.getHarga(), 
                qty, 
                subtotal);
        }
        
        System.out.println("-".repeat(80));
        
        // Total
        double total = cart.hitungTotalHarga();
        System.out.printf("%-61s Rp %-12.0f\n", "TOTAL PEMBAYARAN:", total);
        
        // Payment info
        System.out.println("\n" + "-".repeat(80));
        System.out.println("INFORMASI PEMBAYARAN:");
        System.out.println("Status Pembayaran : LUNAS");
        System.out.println("Jumlah Dibayar    : Rp " + String.format("%.0f", total));
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("              Terima kasih telah berbelanja di POLBAN E-Commerce!");
        System.out.println("                     Barang akan segera dikirim ke alamat Anda.");
        System.out.println("=".repeat(80));
    }
    
    // Check if product has enough stock tanpa mengekspos jumlah stok
    public boolean hasEnoughStock(int productId, int requestedQuantity) {
        Product product = findProductById(productId);
        return product != null && product.canFulfillOrder(requestedQuantity);
    }
    
    // Get product info for display tanpa menampilkan stok
    public String getProductInfo(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            String status = product.isAvailable() ? "Tersedia" : "Habis";
            return product.getNamaProduk() + " (Status: " + status + ")";
        }
        return "Produk tidak ditemukan";
    }
    
    // Method khusus untuk menampilkan informasi stok (hanya untuk admin)
    public void displayStockInfoForAdmin() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                  INFORMASI STOK (ADMIN ONLY)");
        System.out.println("=".repeat(70));
        System.out.printf("%-4s %-25s %-15s %-10s\n", "ID", "Nama Produk", "Harga", "Stok");
        System.out.println("-".repeat(70));
        
        for (Product product : products) {
            int stok = getInternalStockCount(product.getIdProduk());
            System.out.printf("%-4d %-25s Rp %-12.0f %-10d\n", 
                product.getIdProduk(), 
                product.getNamaProduk(), 
                product.getHarga(), 
                stok);
        }
        System.out.println("=".repeat(70));
    }
}