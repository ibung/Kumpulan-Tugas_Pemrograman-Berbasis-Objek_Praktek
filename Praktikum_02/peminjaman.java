import java.time.LocalDate;
import java.time.LocalTime;

public class peminjaman {
    private mahasiswa peminjam;
    private String namaBarang;
    private LocalDate tanggal;
    private LocalTime jamPengambilan;
    private LocalTime jamPengembalian;

    // Constructor
    public peminjaman(mahasiswa peminjam, String namaBarang, LocalDate tanggal, LocalTime jamPengambilan, LocalTime jamPengembalian) {
        this.peminjam = peminjam;
        this.namaBarang = namaBarang;
        this.tanggal = tanggal;
        this.jamPengambilan = jamPengambilan;
        this.jamPengembalian = jamPengembalian;
    }

    // Getter
    public mahasiswa getPeminjam() { 
        return peminjam; 
    }

    public String getNamaBarang() { 
        return namaBarang; 
    }

    public LocalDate getTanggal() {
        return tanggal; 
    }

    public LocalTime getJamPengambilan() { 
        return jamPengambilan; 
    }

    public LocalTime getJamPengembalian() { 
        return jamPengembalian; 
    }

    // Setter
    public void setPeminjam(mahasiswa peminjam) { 
        this.peminjam = peminjam; 
    }

    public void setNamaBarang(String namaBarang) { 
        this.namaBarang = namaBarang; 
    }

    public void setTanggal(LocalDate tanggal) { 
        this.tanggal = tanggal; 
    }

    public void setJamPengambilan(LocalTime jamPengambilan) { 
        this.jamPengambilan = jamPengambilan; 
    }

    public void setJamPengembalian(LocalTime jamPengembalian) { 
        this.jamPengembalian = jamPengembalian; 
    }

    // Method
    public void printStruk() {
        System.out.println("---- Peminjaman ----" +
                "\nPeminjam         : " + peminjam.getNama() + " (" + peminjam.getNim() + ")" +
                "\nProgram Studi    : " + peminjam.getProdi() +
                "\nNama Barang      : " + namaBarang +
                "\nTanggal          : " + tanggal +
                "\nJam Pengambilan  : " + jamPengambilan +
                "\nJam Pengembalian : " + jamPengembalian);
    }
}
