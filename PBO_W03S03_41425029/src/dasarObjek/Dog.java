/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dasarObjek;

/**
 *
 * @author Gaudium
 */

// Class Dog sebagai template untuk membuat objek anjing
public class Dog {
    // Atribut untuk menyimpan state dari objek (nama, ras, umur, warna)
    String name;
    String breed;
    int age;
    String color;

    // Constructor untuk mengisi nilai atribut saat objek pertama kali dibuat
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // Method getter (accessor) 1: mengembalikan nilai nama
    public String getName() {
        return name;
    }

    // Method getter 2: mengembalikan nilai ras
    public String getBreed() {
        return breed;
    }

    // Method getter 3: mengembalikan nilai umur
    public int getAge() {
        return age;
    }

    // Method getter 4: mengembalikan nilai warna
    public String getColor() {
        return color;
    }

    // Meng-override method toString() dari class Object bawaan Java
    // Bertujuan untuk mengembalikan informasi detail objek dalam bentuk String
    @Override 
    public String toString() {
        return ("Name is: " + this.getName()
                + "\nBreed, age, and color are: "
                + this.getBreed() + ", " + this.getAge()
                + ", " + this.getColor());
    }
}