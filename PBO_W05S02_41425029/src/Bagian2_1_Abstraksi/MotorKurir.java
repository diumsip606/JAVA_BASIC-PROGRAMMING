/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian2_1_Abstraksi;

/**
 *
 * @author Gaudium
 */
public class MotorKurir extends KendaraanEkspedisi {
    public MotorKurir(String noPolisi, int kapasitasKg) {
        super(noPolisi, kapasitasKg);
    }

    // Implementasi abstract method (hasil perbaikan opsi 1)
    @Override
    public void angkutBarang(String namaBarang) {
        System.out.println("Motor Kurir [" + noPolisi + "] membawa '" + namaBarang +
                "' di box belakang menembus gang sempit.");
    }
}
