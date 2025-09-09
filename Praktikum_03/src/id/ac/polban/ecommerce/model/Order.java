package id.ac.polban.ecommerce.model;

import java.util.Date;

public class Order {
    private int idOrder;
    private Date tanggalOrder;
    private double totalHarga;
    private String status;

    // Constructor
    public Order(int idOrder, double totalHarga, String status) {
        this.idOrder = idOrder;
        this.tanggalOrder = new Date();
        this.totalHarga = totalHarga;
        this.status = status;
    }

    // Constructor with date
    public Order(int idOrder, Date tanggalOrder, double totalHarga, String status) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    // Default constructor
    public Order() {
        this.tanggalOrder = new Date();
        this.status = "Pending";
    }

    // Getter methods
    public int getIdOrder() {
        return idOrder;
    }

    public Date getTanggalOrder() {
        return tanggalOrder;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getStatus() {
        return status;
    }

    // Setter methods
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setTanggalOrder(Date tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method untuk mengubah status order
    public void ubahStatus(String statusBaru) {
        this.status = statusBaru;
    }

    // Method untuk mengecek apakah order sudah selesai
    public boolean isCompleted() {
        return "Completed".equalsIgnoreCase(status) || 
               "Selesai".equalsIgnoreCase(status);
    }

    // Method untuk mengecek apakah order dibatalkan
    public boolean isCancelled() {
        return "Cancelled".equalsIgnoreCase(status) || 
               "Dibatalkan".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", tanggalOrder=" + tanggalOrder +
                ", totalHarga=" + totalHarga +
                ", status='" + status + '\'' +
                '}';
    }
}