/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author Gaudium
 */
// Multiple Inheritance di Java hanya bisa dilakukan menggunakan Interface
interface LandVehicle {
    default void landInfo() { 
        System.out.println("This is a LandVehicle"); 
    }
}

interface WaterVehicle {
    default void waterInfo() { 
        System.out.println("This is a WaterVehicle"); 
    }
}

// Mengimplementasikan lebih dari satu interface sekaligus
class AmphibiousVehicle implements LandVehicle, WaterVehicle {
    AmphibiousVehicle() {
        System.out.println("This is an AmphibiousVehicle");
    }
}

public class MainMultiple {
    public static void main(String[] args) {
        AmphibiousVehicle obj = new AmphibiousVehicle();
        obj.waterInfo();
        obj.landInfo();
    }
}
