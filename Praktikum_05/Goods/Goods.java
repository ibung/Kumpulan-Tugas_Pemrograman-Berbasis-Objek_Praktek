/**
 * Kelas induk untuk semua barang
 */
public class Goods {
    protected String description;
    protected double price;
    
    // Constructor
    public Goods(String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    // Method display
    public void display() {
        System.out.println("=== Informasi Barang ===");
        System.out.println("Deskripsi: " + description);
        System.out.println("Harga: Rp" + String.format("%.2f", price));
    }
    
    // Getter methods
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setter methods
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Harga tidak boleh negatif!");
        }
    }
}