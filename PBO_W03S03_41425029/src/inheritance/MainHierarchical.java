/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author Gaudium
 */
// Hierarchical Inheritance: satu parent memiliki banyak anak
class VehicleHier {
    VehicleHier() { 
        System.out.println("This is a Vehicle"); 
    }
}

class CarHier extends VehicleHier {
    CarHier() { 
        System.out.println("This Vehicle is Car"); 
    }
}

class BusHier extends VehicleHier {
    BusHier() { 
        System.out.println("This Vehicle is Bus"); 
    }
}

public class MainHierarchical {
    public static void main(String[] args) {
        CarHier obj1 = new CarHier();
        BusHier obj2 = new BusHier();
    }
}
