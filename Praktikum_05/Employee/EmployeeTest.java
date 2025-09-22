/**
 * Class untuk testing Employee dan Manager dengan Sortable
 */
public class EmployeeTest {
    
    public static void main(String[] args) {
        System.out.println("====== TEST SORTABLE DENGAN EMPLOYEE DAN MANAGER ======\n");
        
        // Case 1: Testing Employee sorting
        System.out.println("=== CASE 1: EMPLOYEE SORTING ===\n");
        
        // Membuat array Employee sesuai contoh di soal
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        staff[3] = new Employee("John Smith", 1800000, 15, 5, 1987);
        
        System.out.println("Data Employee sebelum diurutkan:");
        for (int i = 0; i < staff.length; i++) {
            System.out.print((i+1) + ". ");
            staff[i].display();
        }
        
        // Memanggil method shell_sort
        System.out.println("\nMenjalankan shell_sort...\n");
        Sortable.shell_sort(staff);
        
        System.out.println("Data Employee setelah diurutkan berdasarkan gaji:");
        for (int i = 0; i < staff.length; i++) {
            System.out.print((i+1) + ". ");
            staff[i].display();
        }
        
        // Case 2: Testing Manager sorting
        System.out.println("\n=== CASE 2: MANAGER SORTING ===\n");
        
        // Membuat array Manager
        Manager[] managers = new Manager[4];
        managers[0] = new Manager("Sarah Johnson", 5000000, 10, 3, 1985, "IT", 1500000);
        managers[1] = new Manager("David Lee", 4500000, 22, 8, 1982, "Finance", 2000000);
        managers[2] = new Manager("Lisa Wong", 4800000, 5, 12, 1988, "Marketing", 1200000);
        managers[3] = new Manager("Mike Brown", 4200000, 18, 6, 1980, "HR", 1800000);
        
        System.out.println("Data Manager sebelum diurutkan:");
        for (int i = 0; i < managers.length; i++) {
            System.out.print((i+1) + ". ");
            managers[i].display();
        }
        
        System.out.println("\nMenjalankan shell_sort untuk Manager...\n");
        Sortable.shell_sort(managers);
        
        System.out.println("Data Manager setelah diurutkan berdasarkan total gaji:");
        for (int i = 0; i < managers.length; i++) {
            System.out.print((i+1) + ". ");
            managers[i].display();
        }
        
        // Case 3: Testing campuran Employee dan Manager
        System.out.println("\n=== CASE 3: CAMPURAN EMPLOYEE DAN MANAGER ===\n");
        
        Sortable[] mixedStaff = new Sortable[6];
        mixedStaff[0] = new Employee("Regular Employee 1", 3500000, 1, 1, 1990);
        mixedStaff[1] = new Manager("Manager 1", 4000000, 2, 2, 1985, "Sales", 1000000);
        mixedStaff[2] = new Employee("Regular Employee 2", 2800000, 3, 3, 1992);
        mixedStaff[3] = new Manager("Manager 2", 3800000, 4, 4, 1983, "Production", 1500000);
        mixedStaff[4] = new Employee("Regular Employee 3", 4200000, 5, 5, 1988);
        mixedStaff[5] = new Manager("Manager 3", 3600000, 6, 6, 1986, "Quality", 800000);
        
        System.out.println("Data campuran sebelum diurutkan:");
        for (int i = 0; i < mixedStaff.length; i++) {
            System.out.print((i+1) + ". ");
            if (mixedStaff[i] instanceof Manager) {
                ((Manager) mixedStaff[i]).display();
            } else {
                ((Employee) mixedStaff[i]).display();
            }
        }
        
        System.out.println("\nMenjalankan shell_sort untuk data campuran...\n");
        Sortable.shell_sort(mixedStaff);
        
        System.out.println("Data campuran setelah diurutkan:");
        for (int i = 0; i < mixedStaff.length; i++) {
            System.out.print((i+1) + ". ");
            if (mixedStaff[i] instanceof Manager) {
                ((Manager) mixedStaff[i]).display();
            } else {
                ((Employee) mixedStaff[i]).display();
            }
        }
                
        System.out.println("\n====== TEST SELESAI ======");
    }
}