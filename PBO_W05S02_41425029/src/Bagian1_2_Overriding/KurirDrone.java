/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1_2_Overriding;

/**
 *
 * @author Gaudium
 */
// Child class: kurir drone, mewarisi KurirReguler
public class KurirDrone extends KurirReguler {
    // Atribut khusus drone
    private String idDrone;

    // Constructor: memanggil constructor parent via super(), lalu mengisi idDrone
    public KurirDrone(String nama, String idDrone) {
        super(nama);
        this.idDrone = idDrone;
    }

    // OVERRIDING: nama dan parameter sama persis dengan method di parent
    @Override
    public void kirimBarang(String alamat) {
        System.out.println("Unit Drone [" + idDrone + "] operator " + nama +
                " terbang mengantar paket langsung ke koordinat: " + alamat);
    }
}
