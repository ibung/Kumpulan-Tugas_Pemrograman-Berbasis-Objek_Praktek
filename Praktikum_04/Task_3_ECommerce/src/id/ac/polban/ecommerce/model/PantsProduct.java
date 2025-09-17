package id.ac.polban.ecommerce.model;

// INHERITANCE: PantsProduct adalah SUBCLASS dari ApparelProduct.
public class PantsProduct extends ApparelProduct {
    private String pantsType; // Contoh: "Chino", "Jeans", "Cargo"
    private int waistSize;    // Ukuran pinggang dalam angka (misal: 30, 32)

    public PantsProduct(int idProduk, String namaProduk, double harga, String size, String color, String pantsType, int waistSize) {
        // SUPER: Memanggil konstruktor dari superclass (ApparelProduct)
        super(idProduk, namaProduk, harga, size, color);
        this.pantsType = pantsType;
        this.waistSize = waistSize;
    }

    public String getPantsType() {
        return pantsType;
    }

    public int getWaistSize() {
        return waistSize;
    }

    // OVERRIDING: Menambahkan detail spesifik untuk celana
    @Override
    public void displayDetails() {
        // SUPER: Memanggil metode displayDetails() versi ApparelProduct
        super.displayDetails();
        System.out.printf("Tipe  : %s%n", pantsType);
        System.out.printf("Ukuran Pinggang: %d%n", waistSize);
    }
}