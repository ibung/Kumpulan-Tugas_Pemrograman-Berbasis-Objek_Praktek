/**
 * Class Manager yang extends Employee (Case 2)
 */
public class Manager extends Employee {
    private String department;
    private double bonus;
    
    // Constructor
    public Manager(String name, double salary, int day, int month, int year, 
                  String department, double bonus) {
        super(name, salary, day, month, year);
        this.department = department;
        this.bonus = bonus;
    }
    
    // Override method compare untuk Manager
    // Manager diurutkan berdasarkan total gaji (salary + bonus)
    @Override
    public int compare(Sortable b) {
        if (b instanceof Manager) {
            Manager mb = (Manager) b;
            double totalSalaryThis = getSalary() + bonus;
            double totalSalaryOther = mb.getSalary() + mb.bonus;
            
            if (totalSalaryThis < totalSalaryOther) return -1;
            if (totalSalaryThis > totalSalaryOther) return 1;
            return 0;
        } else if (b instanceof Employee) {
            // Bandingkan Manager dengan Employee biasa
            Employee eb = (Employee) b;
            double totalSalaryThis = getSalary() + bonus;
            
            if (totalSalaryThis < eb.getSalary()) return -1;
            if (totalSalaryThis > eb.getSalary()) return 1;
            return 0;
        }
        return 0;
    }
    
    // Getter methods
    public String getDepartment() {
        return department;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public double getTotalSalary() {
        return getSalary() + bonus;
    }
    
    // Override display method
    @Override
    public void display() {
        System.out.println("Manager - Nama: " + getName() + 
                          ", Gaji Pokok: Rp" + String.format("%.0f", getSalary()) +
                          ", Bonus: Rp" + String.format("%.0f", bonus) +
                          ", Total: Rp" + String.format("%.0f", getTotalSalary()) +
                          ", Departemen: " + department +
                          ", Tanggal Lahir: " + getDay() + "/" + getMonth() + "/" + getYear());
    }
    
    @Override
    public String toString() {
        return "Manager{name='" + getName() + "', salary=" + getSalary() + 
               ", bonus=" + bonus + ", totalSalary=" + getTotalSalary() +
               ", department='" + department + "', birthDate=" + 
               getDay() + "/" + getMonth() + "/" + getYear() + "}";
    }
}