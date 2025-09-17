package id.ac.polban.ecommerce.model;

public class Product {
    private int idProduk;
    private String namaProduk;
    private double harga;

    public Product(int idProduk, String namaProduk, double harga) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void displayDetails() {
        System.out.printf("ID    : %d%n", idProduk);
        System.out.printf("Nama  : %s%n", namaProduk);
        System.out.printf("Harga : Rp %,.0f%n", harga);
    }
}