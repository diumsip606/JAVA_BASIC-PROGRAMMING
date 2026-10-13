/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classObjek;

/**
 *
 * @author Gaudium
 */
public class TestEquals {
    int roll;

    // Override equals() untuk membandingkan kesamaan nilai atribut roll
    @Override
    public boolean equals(Object o) {
        if (o instanceof TestEquals) {
            return this.roll == ((TestEquals) o).roll;
        }
        return false;
    }

    public static void main(String[] args) {
        TestEquals s1 = new TestEquals(); s1.roll = 101;
        TestEquals s2 = new TestEquals(); s2.roll = 101;
        TestEquals s3 = new TestEquals(); s3.roll = 102;

        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}
