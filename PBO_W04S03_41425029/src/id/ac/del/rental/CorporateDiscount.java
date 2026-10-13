/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Gaudium
 */
public class CorporateDiscount implements Discountable {
    @Override
    public double calculateDiscount(double amount) {
        // 15% dari total = amount * 0.15
        return amount * 0.15;
    }
}
