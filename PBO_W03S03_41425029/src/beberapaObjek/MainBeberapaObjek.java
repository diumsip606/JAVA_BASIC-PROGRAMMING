/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beberapaObjek;

/**
 *
 * @author Gaudium
 */
// Kelas induk (Parent class)
class Animal {
    // Method dasar untuk dioverride oleh kelas anak
    void cekIdentitas() {
        System.out.println("Ini adalah seekor hewan");
    }
}

// Kelas anak 1 (Subclass) yang mewarisi Animal
class Dog extends Animal {
    @Override
    void cekIdentitas() {
        System.out.println("Ini adalah seekor Anjing (Dog)");
    }
}

// Kelas anak 2 (Subclass) yang mewarisi Animal
class Cat extends Animal {
    @Override
    void cekIdentitas() {
        System.out.println("Ini adalah seekor Kucing (Cat)");
    }
}

// Class utama
public class MainBeberapaObjek {
    public static void main(String[] args) {
        
        // Membuat SATU variabel referensi bertipe kelas induk (Animal)
        Animal obj; 
        
        // Menyimpan objek Dog ke dalam referensi kelas induk
        obj = new Dog(); 
        obj.cekIdentitas(); // Output: Ini adalah seekor Anjing (Dog)
        
        // Menggunakan variabel referensi yang SAMA untuk menyimpan objek Cat
        obj = new Cat(); 
        obj.cekIdentitas(); // Output: Ini adalah seekor Kucing (Cat)
    }
}
