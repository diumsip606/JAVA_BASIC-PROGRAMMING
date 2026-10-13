/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enkapsulasi;

/**
 *
 * @author Gaudium
 */
class ObjectPassDemo {
    int a, b;

    ObjectPassDemo(int i, int j) {
        a = i;
        b = j;
    }

    // Method menerima objek sebagai parameter untuk dibandingkan
    boolean equalTo(ObjectPassDemo o) {
        return (o.a == a && o.b == b);
    }
}

public class MainPassObject {
    public static void main(String[] args) {
        ObjectPassDemo ob1 = new ObjectPassDemo(100, 22);
        ObjectPassDemo ob2 = new ObjectPassDemo(100, 22);
        ObjectPassDemo ob3 = new ObjectPassDemo(-1, -1);

        System.out.println("ob1 == ob2: " + ob1.equalTo(ob2));
        System.out.println("ob1 == ob3: " + ob1.equalTo(ob3));
    }
}
