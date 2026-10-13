/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian2_1_Abstraksi;

/**
 *
 * @author Gaudium
 */
public class SimulasiAbstraksi {
    public static void main(String[] args) {
        System.out.println("=== INI ABSTRACT CLASS ===");

        // PERCOBAAN 1: larangan instansiasi langsung abstract class
        // Jika komentar dibuka -> error: KendaraanEkspedisi is abstract; cannot be instantiated
        // KendaraanEkspedisi k = new KendaraanEkspedisi("BK 1234 DEL", 100);

        // PERCOBAAN 2: instansiasi dari subclass konkret (diperbolehkan)
        TrukBox fuso = new TrukBox("B 9081 TXT", 5000);
        fuso.infoKendaraan();                 // concrete method warisan parent
        fuso.angkutBarang("20 Unit Kulkas");  // implementasi milik TrukBox

        System.out.println("---------------------------------");

        MobilVan grandmax = new MobilVan("B 1122 KAA", 800);
        grandmax.infoKendaraan();
        grandmax.angkutBarang("50 Kotak Sepatu");

        System.out.println("---------------------------------");

        // Subclass konkret hasil Eksperimen 2
        MotorKurir motor = new MotorKurir("BK 2024 DEL", 50);
        motor.infoKendaraan();
        motor.angkutBarang("10 Dokumen");
    }
}


/*
LEMBAR ANALISIS ABSTRAKSI
Eksperimen 1
   Baris PERCOBAAN 1 dibuka komentarnya:
   KendaraanEkspedisi k = new KendaraanEkspedisi("BK 1234 DEL", 100);
   Pesan error:
   KendaraanEkspedisi is abstract; cannot be instantiated
   Mengapa Java menggagalkan baris ini?
   KendaraanEkspedisi adalah abstract class, yaitu konsep/kerangka yang belum
   lengkap karena memiliki abstract method angkutBarang() yang belum punya
   isi. Sesuai "Kotak Insight Konsep", dealer menolak pesanan "Kendaraan
   Ekspedisi" karena bentuk fisiknya belum jelas (roda berapa, bahan bakar
   apa, cara mengangkut bagaimana). Jika objeknya boleh dibuat, memanggil
   angkutBarang() akan menjalankan method tanpa body. Karena itu Java
   melarang new pada abstract class. Objek hanya boleh dibuat dari subclass
   konkret (TrukBox, MobilVan, MotorKurir) yang sudah mengimplementasikan
   semua abstract method.

Eksperimen 2
   Class MotorKurir extends KendaraanEkspedisi dibuat tanpa method
   angkutBarang().
   Pesan error pada garis merah "class MotorKurir":
   MotorKurir is not abstract and does not override abstract method
   angkutBarang(String) in KendaraanEkspedisi
   Penyebab: subclass konkret (bukan abstract) wajib mengimplementasikan
   semua abstract method milik parent-nya.
   Dua opsi solusi yang ditawarkan IDE:
   1. Implement all abstract methods
      IDE otomatis menambahkan kerangka method angkutBarang() ke MotorKurir,
      lalu programmer mengisi body-nya.
   2. Make class MotorKurir abstract
      MotorKurir dijadikan abstract class sehingga tidak wajib
      mengimplementasikan method tersebut, tetapi MotorKurir tidak bisa
      di-new dan subclass di bawahnya yang harus mengimplementasikan.
   Pada project ini dipilih opsi 1 (lihat MotorKurir.java).
 */