/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1_2_Overriding;

/**
 *
 * @author Gaudium
 */

// Parent class: kurir motor reguler
public class KurirReguler {
    // protected: bisa diakses subclass (KurirDrone)
    protected String nama;

    // Constructor untuk mengisi nama kurir
    public KurirReguler(String nama) {
        this.nama = nama;
    }

    // Method standar: pengiriman lewat jalur darat
    public void kirimBarang(String alamat) {
        System.out.println(nama + " mengantar paket ke " + alamat + " lewat jalur darat menembus kemacetan.");
    }
}