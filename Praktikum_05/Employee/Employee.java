/**
 * Class Employee yang extends Sortable
 */
public class Employee extends Sortable {
    private String name;
    private double salary;
    private int day;
    private int month;
    private int year;
    
    // Constructor
    public Employee(String name, double salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    // Implementation method compare dari abstract class Sortable
    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;
        if (salary < eb.salary) return -1;
        if (salary > eb.salary) return 1;
        return 0; // salary sama
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getDay() {
        return day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    // Method untuk menampilkan informasi employee
    public void display() {
        System.out.println("Nama: " + name + 
                          ", Gaji: Rp" + String.format("%.0f", salary) + 
                          ", Tanggal Lahir: " + day + "/" + month + "/" + year);
    }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + 
               ", birthDate=" + day + "/" + month + "/" + year + "}";
    }
}