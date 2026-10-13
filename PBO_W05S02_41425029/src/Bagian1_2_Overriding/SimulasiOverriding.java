/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1_2_Overriding;

/**
 *
 * @author Gaudium
 */
// Class utama simulasi method overriding
public class SimulasiOverriding {
    public static void main(String[] args) {
        System.out.println("=== INI METHOD OVERRIDING ===");

        // Referensi parent, objek asli KurirReguler
        KurirReguler k1 = new KurirReguler("Budi");

        // Referensi parent, objek asli KurirDrone (upcasting)
        KurirReguler k2 = new KurirDrone("Arka", "DRN-01");

        // JVM memilih method berdasarkan OBJEK ASLI saat runtime (dynamic binding)
        k1.kirimBarang("Jl. Sudirman No. 10");  // versi KurirReguler
        k2.kirimBarang("Gedung Graha Lt. 5");   // versi KurirDrone
    }
}

/*
LEMBAR ANALISIS OVERRIDING
1. Pada class KurirDrone, @Override dihapus/dikomentari, lalu nama method
   diubah menjadi kirimbarang(String alamat) (b kecil). Apa output dari
   k2.kirimBarang("Gedung Graha Lt. 5")? Apakah masih "lewat jalur udara"
   atau berubah menjadi "lewat jalur darat"?
   Output:
   Arka mengantar paket ke Gedung Graha Lt. 5 lewat jalur darat menembus kemacetan.
   Jadi berubah menjadi "lewat jalur darat". Java bersifat case-sensitive,
   sehingga kirimbarang (b kecil) dianggap method BARU di KurirDrone, bukan
   override dari kirimBarang. Akibatnya, saat k2.kirimBarang(...) dipanggil,
   yang dijalankan adalah versi milik KurirReguler. Tidak ada error kompilasi,
   sehingga kesalahan ini tidak langsung terlihat.

2. Setelah @Override dikembalikan di atas method yang salah ketik, lalu
   dikompilasi ulang, pesan error yang muncul:
   method does not override or implement a method from a supertype

3. Fungsi utama @Override bagi programmer:
   @Override memberi tahu compiler bahwa method tersebut HARUS menimpa method
   milik parent class, lalu compiler memverifikasinya. Jika tidak ada method
   yang cocok di parent (nama salah ketik, tipe parameter berbeda, atau
   method parent berganti nama), compiler langsung menampilkan error. Tanpa
   @Override, kesalahan baru ketahuan dari perilaku program yang keliru saat
   runtime. Selain itu, kode juga lebih mudah dibaca karena jelas bahwa
   method tersebut hasil overriding.
 */
