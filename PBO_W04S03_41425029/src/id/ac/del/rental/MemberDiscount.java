/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Gaudium
 */
public class MemberDiscount implements Discountable {
    @Override
    public double calculateDiscount(double amount) {
        // 10% dari total = amount * 0.10
        return amount * 0.10;
    }
}
