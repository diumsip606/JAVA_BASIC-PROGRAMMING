/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classObjek;

/**
 *
 * @author Gaudium
 */
public class TestHashCode {
    int roll;

    // Override hashCode() untuk mengembalikan nilai unik berdasarkan atribut roll
    @Override
    public int hashCode() {
        return roll;
    }

    public static void main(String[] args) {
        TestHashCode s1 = new TestHashCode();
        s1.roll = 101;
        TestHashCode s2 = new TestHashCode();
        s2.roll = 102;
        
        System.out.println("HashCode s1: " + s1.hashCode());
        System.out.println("HashCode s2: " + s2.hashCode());
    }
}
