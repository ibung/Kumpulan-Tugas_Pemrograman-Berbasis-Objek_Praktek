/**
 * Abstract class Sortable
 */
public abstract class Sortable {
    // Abstract method yang harus diimplementasikan oleh subclass
    public abstract int compare(Sortable b);
    
    // Static method untuk shell sort
    public static void shell_sort(Sortable[] a) {
        int n = a.length;
        
        // Mulai dengan gap besar, kemudian kurangi gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Lakukan gapped insertion sort untuk gap ini
            for (int i = gap; i < n; i++) {
                // Simpan a[i] dalam temp dan buat lubang di posisi i
                Sortable temp = a[i];
                
                // Geser elemen yang sudah diurutkan sebelumnya sampai
                // menemukan posisi yang tepat untuk a[i]
                int j;
                for (j = i; j >= gap && a[j - gap].compare(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                
                // Letakkan temp di posisi yang benar
                a[j] = temp;
            }
        }
    }
}