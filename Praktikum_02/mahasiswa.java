public class mahasiswa {
    private String nama;
    private long nim;
    private String prodi;

    // Constructor
    public mahasiswa(String nama, long nim, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
    }

    // Getter
    public String getNama() { 
        return nama; 
    }

    public long getNim() { 
        return nim; 
    }

    public String getProdi() { 
        return prodi; 
    }

    // Setter
    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public void setNim(long nim) { 
        this.nim = nim; 
    }

    public void setProdi(String prodi) { 
        this.prodi = prodi; 
    }

    // Method
    public void printProfil() {
        System.out.println("---- Mahasiswa ----" +
                "\nNama  : " + nama +
                "\nNIM   : " + nim +
                "\nProdi : " + prodi +
                "\n");
    }
}
