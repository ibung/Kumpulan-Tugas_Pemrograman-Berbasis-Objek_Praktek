import java.time.LocalDate;
import java.time.LocalTime;

public class main {
    public static void main(String[] args) {
        // Data Mahasiswa
        mahasiswa m = new mahasiswa("Ibnu Hilmi", 241511079L, "D3 Informatika");
        m.printProfil();

        // Contoh peminjaman 
        peminjaman p = new peminjaman(m, "Proyektor", LocalDate.of(2025, 8, 28), LocalTime.of(12, 0), LocalTime.of(13, 30));
        p.printStruk();
    }
}
