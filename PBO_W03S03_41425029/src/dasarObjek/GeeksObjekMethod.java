/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dasarObjek;

/**
 *
 * @author Gaudium
 */
public class GeeksObjekMethod {
    static String name;
    static float price;
    
    static void set(String n, float p) {
        name = n;
        price = p;
    }
    
    static void get ()
    {
        System.out.println("Software name is:" + name);
        System.out.println("Software price is:" + price);
    }
    
    public static void main(String args[])
    {
        GeeksObjekMethod.set("Visual studio", 0.0f);
        GeeksObjekMethod.get();
    }
}
