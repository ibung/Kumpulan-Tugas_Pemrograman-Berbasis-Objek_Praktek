package id.ac.polban.ecommerce.model;

public class Product {
    private int idProduk;
    private String namaProduk;
    private double harga;
    // Variabel stok dihilangkan/disembunyikan
    // private int stok;  // <- Commented out untuk "menghilangkan" stok
    
    // Alternatif 1: Gunakan variabel dengan nama yang berbeda dan akses terbatas
    private int inventoryCount; // Ganti nama variabel stok
    
    // Constructor - parameter stok masih ada tapi disimpan dengan nama berbeda
    public Product(int idProduk, String namaProduk, double harga, int stok) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.inventoryCount = stok; // Simpan ke variabel dengan nama berbeda
    }

    // Default constructor
    public Product() {}

    // Getter methods untuk variabel yang masih tersedia
    public int getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    // Getter stok dihilangkan - tidak dapat diakses langsung
    // public int getStok() {
    //     return stok;
    // }
    
    // Alternatif: Method untuk cek ketersediaan tanpa mengekspos jumlah stok
    public boolean isAvailable() {
        return inventoryCount > 0;
    }
    
    // Method untuk cek apakah stok mencukupi tanpa mengekspos jumlah
    public boolean canFulfillOrder(int requestedQuantity) {
        return inventoryCount >= requestedQuantity;
    }

    // Setter methods
    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Setter stok dihilangkan
    // public void setStok(int stok) {
    //     this.stok = stok;
    // }

    // Method untuk mengurangi stok - masih berfungsi tapi tidak mengekspos jumlah
    public boolean kurangiStok(int jumlah) {
        if (inventoryCount >= jumlah) {
            inventoryCount -= jumlah;
            return true;
        }
        return false;
    }

    // Method untuk menambah stok - akses terbatas
    protected void tambahStok(int jumlah) { // Changed to protected
        if (jumlah > 0) {
            inventoryCount += jumlah;
        }
    }
    
    // Method khusus untuk admin/system untuk mengecek stok
    protected int getInternalInventoryCount() {
        return inventoryCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduk=" + idProduk +
                ", namaProduk='" + namaProduk + '\'' +
                ", harga=" + harga +
                ", status=" + (isAvailable() ? "Tersedia" : "Habis") +
                '}';
    }
}