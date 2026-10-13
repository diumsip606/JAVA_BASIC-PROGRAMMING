/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Gaudium
 */
public class FlashSaleDiscount implements Discountable {
    @Override
    public double calculateDiscount(double amount) {
        // 25% dari total = amount * 0.25
        return amount * 0.25;
    }
}
