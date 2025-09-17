package id.ac.polban.ecommerce.model;

public class BeverageProduct extends FoodProduct {
    private int volumeMl; // Volume dalam mililiter

    public BeverageProduct(int idProduk, String namaProduk, double harga, String expirationDateStr, int volumeMl) {
        super(idProduk, namaProduk, harga, expirationDateStr);
        this.volumeMl = volumeMl;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Volume: %d ml%n", volumeMl);
    }
}