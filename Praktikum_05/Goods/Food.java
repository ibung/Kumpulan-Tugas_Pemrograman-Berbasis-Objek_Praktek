/**
 * Kelas Food turunan dari Goods (tidak dikenakan pajak)
 */
public class Food extends Goods {
    private int calories;
    
    // Constructor
    public Food(String description, double price, int calories) {
        super(description, price);
        this.calories = calories;
    }
    
    @Override
    public void display() {
        System.out.println("=== Informasi Makanan ===");
        System.out.println("Deskripsi: " + description);
        System.out.println("Harga: Rp" + String.format("%.2f", price));
        System.out.println("Kalori: " + calories);
        System.out.println("Status: Bebas pajak");
    }
    
    // Getter dan Setter
    public int getCalories() {
        return calories;
    }
    
    public void setCalories(int calories) {
        if (calories >= 0) {
            this.calories = calories;
        } else {
            System.out.println("Kalori tidak boleh negatif!");
        }
    }
    
    public boolean isHealthy() {
        return calories <= 100;
    }
}