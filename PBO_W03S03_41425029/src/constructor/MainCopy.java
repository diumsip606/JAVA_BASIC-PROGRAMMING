/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author Gaudium
 */
class GeeksCopy {
    String name;
    int id;

    GeeksCopy(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Copy Constructor: menerima objek lain sebagai parameter untuk disalin
    GeeksCopy(GeeksCopy obj2) {
        this.name = obj2.name;
        this.id = obj2.id;
    }
}

public class MainCopy {
    public static void main(String[] args) {
        GeeksCopy geek1 = new GeeksCopy("Sweta", 68);
        System.out.println("First Object -> GeekName: " + geek1.name + " and GeekId: " + geek1.id);

        GeeksCopy geek2 = new GeeksCopy(geek1);
        System.out.println("Copy Constructor -> GeekName: " + geek2.name + " and GeekId: " + geek2.id);
    }
}