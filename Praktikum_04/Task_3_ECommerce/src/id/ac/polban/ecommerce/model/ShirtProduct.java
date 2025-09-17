package id.ac.polban.ecommerce.model;

public class ShirtProduct extends ApparelProduct {
    private String sleeveType;

    public ShirtProduct(int idProduk, String namaProduk, double harga, String size, String color, String sleeveType) {
        super(idProduk, namaProduk, harga, size, color);
        this.sleeveType = sleeveType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Model : %s%n", sleeveType);
    }
}