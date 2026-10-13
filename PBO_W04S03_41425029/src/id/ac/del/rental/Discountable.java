/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Gaudium
 */
public interface Discountable {
    // Menerima total harga (amount), mengembalikan NILAI POTONGAN dalam rupiah (bukan harga akhir).
    double calculateDiscount(double amount);
}
