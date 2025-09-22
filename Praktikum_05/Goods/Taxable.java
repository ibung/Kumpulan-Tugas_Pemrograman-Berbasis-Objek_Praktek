/**
 * Interface untuk objek yang dikenakan pajak
 */
public interface Taxable {
    double TAX_RATE = 0.06; // Tarif pajak 6%
    
    double calculateTax();
}