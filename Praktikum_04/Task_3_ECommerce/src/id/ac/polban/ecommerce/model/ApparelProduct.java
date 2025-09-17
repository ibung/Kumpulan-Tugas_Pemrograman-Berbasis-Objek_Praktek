package id.ac.polban.ecommerce.model;

public class ApparelProduct extends Product {
    private String size;
    private String color;

    public ApparelProduct(int idProduk, String namaProduk, double harga, String size, String color) {
        super(idProduk, namaProduk, harga);
        this.size = size;
        this.color = color;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Ukuran: %s%n", size);
        System.out.printf("Warna : %s%n", color);
    }
}