/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tantangan_Ekstra;

import Bagian2_1_Abstraksi.KendaraanEkspedisi;
import Bagian2_1_Abstraksi.MobilVan;
import Bagian2_1_Abstraksi.MotorKurir;
import Bagian2_1_Abstraksi.TrukBox;
/**
 *
 * @author Gaudium
 */

/*
 * TANTANGAN EKSTRA: POLIMORFISME
 *
 * Array bertipe parent (KendaraanEkspedisi[]) diisi objek child yang berbeda.
 * Satu for-loop memanggil angkutBarang() lewat referensi parent, tanpa if/instanceof.
 * JVM memilih versi method yang tepat berdasarkan objek asli saat runtime
 * (dynamic binding). Jika ada kendaraan baru, loop tidak perlu diubah.
 */
public class SimulasiPolimorfisme {
    public static void main(String[] args) {
        System.out.println("=== TANTANGAN EKSTRA: POLIMORFISME ===");

        // Array bertipe parent, isinya objek child yang berbeda (upcasting otomatis)
        KendaraanEkspedisi[] armada = {
            new TrukBox("B 9081 TXT", 5000),
            new MobilVan("B 1122 KAA", 800),
            new MotorKurir("BK 2024 DEL", 50)
        };

        // Satu for-loop untuk seluruh armada
        for (KendaraanEkspedisi kendaraan : armada) {
            kendaraan.infoKendaraan();                  // concrete method dari parent
            kendaraan.angkutBarang("Paket Ekspedisi");  // versi child dipilih saat runtime
            System.out.println("---------------------------------");
        }
    }
}


