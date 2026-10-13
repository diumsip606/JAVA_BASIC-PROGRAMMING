/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author Gaudium
 */
class GeeksParam {
    String name;
    int id;

    // Parameterized Constructor: memiliki parameter
    GeeksParam(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class MainParam {
    public static void main(String[] args) {
        GeeksParam geek1 = new GeeksParam("Sweta", 68);
        System.out.println("GeekName: " + geek1.name + " and GeekId: " + geek1.id);
    }
}
