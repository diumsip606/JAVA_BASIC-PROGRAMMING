/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author Gaudium
 */
class GeeksOverload {
    // Constructor dengan 1 parameter String
    GeeksOverload(String name) {
        System.out.println("Constructor with one argument String: " + name);
    }

    // Constructor dengan 2 parameter
    GeeksOverload(String name, int age) {
        System.out.println("Constructor with two arguments: " + name + " " + age);
    }

    // Constructor dengan 1 parameter tipe beda (long)
    GeeksOverload(long id) {
        System.out.println("Constructor with one argument Long: " + id);
    }
}

public class MainOverloading {
    public static void main(String[] args) {
        GeeksOverload geek1 = new GeeksOverload("Sweta");
        GeeksOverload geek2 = new GeeksOverload("Amiya", 28);
        GeeksOverload geek3 = new GeeksOverload(325614567L);
    }
}
