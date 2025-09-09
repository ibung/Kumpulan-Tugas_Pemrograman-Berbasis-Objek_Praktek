package id.ac.polban.ecommerce.model;

public class Customer {

    private int idCustomer;      
    private String nama;
    private String email;
    private String alamat;
    private String noHP; // Changed from int to String

    // Constructor - changed noHP parameter to String
    public Customer(int idCustomer, String nama, String email, String alamat, String noHP) {
        this.idCustomer = idCustomer;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    // Getter
    public int getIdCustomer() {
        return idCustomer;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHP() { // Changed return type to String
        return noHP;
    }

    // Added method for formatted phone number display
    public String getFormattedNoHP() {
        if (noHP == null || noHP.isEmpty()) {
            return noHP;
        }
        // Simple formatting - you can customize this as needed
        return noHP;
    }

    // Setter
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHP(String noHP) { // Changed parameter type to String
        this.noHP = noHP;
    }
}