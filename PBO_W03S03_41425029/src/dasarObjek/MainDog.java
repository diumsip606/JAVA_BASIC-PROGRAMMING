/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dasarObjek;

/**
 *
 * @author Gaudium
 */

public class MainDog {
    // Method main untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek baru bernama tuffy dari class Dog beserta nilai awal atributnya
        Dog tuffy = new Dog("tuffy", "papillon", 5, "white");
        
        // Memanggil method toString() dari objek tuffy untuk mencetak datanya ke layar
        System.out.println(tuffy.toString());
    }
}
