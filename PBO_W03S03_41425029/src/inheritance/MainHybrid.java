/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author Gaudium
 */
// Hybrid Inheritance: Gabungan dari beberapa jenis inheritance (Class dan Interface)
class VehicleHybrid {
    void showVehicle() {
        System.out.println("This is a generic Vehicle");
    }
}

interface ElectricPower {
    default void chargeBattery() {
        System.out.println("Charging electric battery...");
    }
}

// Mewarisi 1 Class (Single) dan 1 Interface (Multiple)
class HybridCar extends VehicleHybrid implements ElectricPower {
    HybridCar() {
        System.out.println("This is a Hybrid Car");
    }
}

public class MainHybrid {
    public static void main(String[] args) {
        HybridCar myCar = new HybridCar();
        myCar.showVehicle();
        myCar.chargeBattery();
    }
}