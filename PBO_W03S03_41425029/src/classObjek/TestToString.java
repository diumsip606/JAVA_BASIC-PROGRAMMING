/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classObjek;

/**
 *
 * @author Gaudium
 */
public class TestToString {
    // Override method toString() dari class Object
    @Override
    public String toString() {
        return "Student object";
    }

    public static void main(String[] args) {
        TestToString s = new TestToString();
        System.out.println(s.toString());
    }
}
