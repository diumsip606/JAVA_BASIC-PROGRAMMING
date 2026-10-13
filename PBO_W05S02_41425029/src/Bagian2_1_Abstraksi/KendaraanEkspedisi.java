/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian2_1_Abstraksi;

/**
 *
 * @author Gaudium
 */
// Abstract class: blueprint/SOP semua kendaraan ekspedisi, tidak boleh di-new
public abstract class KendaraanEkspedisi {
    // Atribut yang diwariskan ke semua subclass
    protected String noPolisi;
    protected int kapasitasKg;

    // Constructor (dipanggil subclass lewat super())
    public KendaraanEkspedisi(String noPolisi, int kapasitasKg) {
        this.noPolisi = noPolisi;
        this.kapasitasKg = kapasitasKg;
    }

    // Concrete method: punya body, diwariskan apa adanya
    public void infoKendaraan() {
        System.out.println("Plat Nomor: " + noPolisi + " | Daya Angkut: " + kapasitasKg + " Kg");
    }

    // Abstract method: tanpa body, diakhiri ';'. Wajib diimplementasikan subclass konkret
    public abstract void angkutBarang(String namaBarang);
}
