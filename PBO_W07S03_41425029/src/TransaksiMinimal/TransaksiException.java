/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TransaksiMinimal;

/**
 *
 * @author Gaudium
 */

// kasusnya yaitu posisi transfer minimal 10rb
public class TransaksiException extends Exception {
    private double nominal;
    
    // constructor menerima pesan dan nominal
    public TransaksiException(String pesan, double nominal) {
        super(pesan);
        this.nominal = nominal;
    }
    
    //getter untuk ambil nominal yang gagal
    public double getNominal() {
        return nominal;
    }

    
}
