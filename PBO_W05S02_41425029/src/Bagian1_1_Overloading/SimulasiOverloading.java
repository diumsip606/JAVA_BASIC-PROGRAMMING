/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1_1_Overloading;

/**
 *
 * @author Gaudium
 */
public class SimulasiOverloading {
    public static void main(String[] args) {
        MesinTarif tarif = new MesinTarif("Medan");
        
        System.out.println("=== INI METHOD OVERLOADING ===");
        System.out.println("Ongkir Biasa (2.0 Kg)       : Rp " + tarif.hitungOngkir(2.0));
        System.out.println("Ongkir + Asuransi (Barang 5Jt) : Rp " + tarif.hitungOngkir(2.0, 5000000.0));
        System.out.println("Ongkir Express (2.0 Kg)     : Rp " + tarif.hitungOngkir(2.0, true));
    }
}

/*
LEMBAR ANALISIS OVERLOADING
1. Mengapa compiler Java dapat menentukan method hitungOngkir mana yang
   dijalankan sebelum program dieksekusi (compile-time)? Bagian method apa
   yang diperiksa compiler?
   Compiler memeriksa DAFTAR PARAMETER pada pemanggilan method, yaitu jumlah,
   tipe data, dan urutan parameternya. Informasi ini sudah pasti di kode
   sumber, sehingga compiler cukup mencocokkan argumen dengan signature
   yang tersedia:
   hitungOngkir(2.0)            -> (double)          -> versi dasar
   hitungOngkir(2.0, 5000000.0) -> (double, double)  -> versi asuransi
   hitungOngkir(2.0, true)      -> (double, boolean) -> versi express
   Proses ini disebut static binding (early binding), karena keputusannya
   sudah final saat kompilasi dan tidak bergantung pada objek saat runtime.
 
2. Jika ditambahkan method
   public int hitungOngkir(double beratKg) { return (int)(beratKg * 10000); }
   mengapa compiler menolak padahal tipe kembaliannya berbeda (int vs double)?
   Karena RETURN TYPE bukan bagian dari method signature. Signature hanya
   terdiri dari nama method + daftar parameter. Kedua method sama-sama
   hitungOngkir(double), sehingga compiler tidak bisa membedakannya saat ada
   pemanggilan tarif.hitungOngkir(2.0). 
   Error yang muncul:
   method hitungOngkir(double) is already defined in class MesinTarif
   Agar sah sebagai overloading, parameter harus berbeda (jumlah, tipe,
   atau urutan).
 */