/**
 * Kelas Book turunan dari Goods dan implementasi Taxable
 */
public class Book extends Goods implements Taxable {
    private String author;
    
    // Constructor
    public Book(String description, double price, String author) {
        super(description, price);
        this.author = author;
    }
    
    @Override
    public void display() {
        System.out.println("=== Informasi Buku ===");
        System.out.println("Judul: " + description);
        System.out.println("Penulis: " + author);
        System.out.println("Harga: Rp" + String.format("%.2f", price));
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
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Nama penulis tidak boleh kosong!");
        }
    }
    
    public String getFullBookInfo() {
        return description + " oleh " + author;
    }
    
    public boolean isExpensive() {
        return price > 50000; // Rp 50.000
    }
    
    public boolean isByAuthor(String otherAuthor) {
        return author.equalsIgnoreCase(otherAuthor);
    }
}