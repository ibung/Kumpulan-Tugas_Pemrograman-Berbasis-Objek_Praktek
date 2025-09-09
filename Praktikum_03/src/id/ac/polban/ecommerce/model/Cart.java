package id.ac.polban.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    private int idCart;
    private Date tanggalDibuat;
    private ArrayList<Product> daftarProduk;

    // Constructor
    public Cart(int idCart) {
        this.idCart = idCart;
        this.tanggalDibuat = new Date();
        this.daftarProduk = new ArrayList<>();
    }

    // Constructor with date
    public Cart(int idCart, Date tanggalDibuat) {
        this.idCart = idCart;
        this.tanggalDibuat = tanggalDibuat;
        this.daftarProduk = new ArrayList<>();
    }

    // Default constructor
    public Cart() {
        this.tanggalDibuat = new Date();
        this.daftarProduk = new ArrayList<>();
    }

    // Getter methods
    public int getIdCart() {
        return idCart;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public ArrayList<Product> getDaftarProduk() {
        return daftarProduk;
    }

    // Setter methods
    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public void setDaftarProduk(ArrayList<Product> daftarProduk) {
        this.daftarProduk = daftarProduk;
    }

    // Method untuk menambah produk ke cart
    public void tambahProduk(Product produk) {
        if (produk != null) {
            daftarProduk.add(produk);
        }
    }

    // Method untuk menghapus produk dari cart
    public boolean hapusProduk(Product produk) {
        return daftarProduk.remove(produk);
    }

    // Method untuk menghitung total harga
    public double hitungTotalHarga() {
        double total = 0;
        for (Product produk : daftarProduk) {
            total += produk.getHarga();
        }
        return total;
    }

    // Method untuk mengosongkan cart
    public void kosongkanCart() {
        daftarProduk.clear();
    }

    // Method untuk mendapatkan jumlah produk
    public int getJumlahProduk() {
        return daftarProduk.size();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idCart=" + idCart +
                ", tanggalDibuat=" + tanggalDibuat +
                ", jumlahProduk=" + daftarProduk.size() +
                ", totalHarga=" + hitungTotalHarga() +
                '}';
    }
}