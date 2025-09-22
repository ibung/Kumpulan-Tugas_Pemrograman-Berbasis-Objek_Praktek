/**
 * Kelas Toy turunan dari Goods dan implementasi Taxable
 */
public class Toy extends Goods implements Taxable {
    private int minimumAge;
    
    // Constructor
    public Toy(String description, double price, int minimumAge) {
        super(description, price);
        this.minimumAge = minimumAge;
    }
    
    @Override
    public void display() {
        System.out.println("=== Informasi Mainan ===");
        System.out.println("Deskripsi: " + description);
        System.out.println("Harga: Rp" + String.format("%.2f", price));
        System.out.println("Usia minimum: " + minimumAge + " tahun");
        System.out.println("Tarif pajak: " + (TAX_RATE * 100) + "%");
        System.out.println("Jumlah pajak: Rp" + String.format("%.2f", calculateTax()));
        System.out.println("Total harga: Rp" + String.format("%.2f", getTotalPrice()));
    }
    
    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }
    
    public double getTotalPrice() {
        return price + calculateTax();
    }
    
    // Getter dan Setter
    public int getMinimumAge() {
        return minimumAge;
    }
    
    public void setMinimumAge(int minimumAge) {
        if (minimumAge >= 0) {
            this.minimumAge = minimumAge;
        } else {
            System.out.println("Usia minimum tidak boleh negatif!");
        }
    }
    
    public boolean isForToddlers() {
        return minimumAge <= 3;
    }
    
    public boolean isSafeForAge(int childAge) {
        return childAge >= minimumAge;
    }
}