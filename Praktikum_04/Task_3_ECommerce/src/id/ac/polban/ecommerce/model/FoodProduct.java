package id.ac.polban.ecommerce.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FoodProduct extends Product {
    private LocalDate expirationDate;

    public FoodProduct(int idProduk, String namaProduk, double harga, String expirationDateStr) {
        super(idProduk, namaProduk, harga);
        this.expirationDate = LocalDate.parse(expirationDateStr); // Format YYYY-MM-DD
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.printf("Baik Digunakan Sebelum: %s%n", expirationDate.format(formatter));
    }
}