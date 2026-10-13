/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.test;
// Class dari package LAIN harus di-import dulu supaya bisa dipakai di sini.
import id.ac.del.rental.CorporateDiscount;
import id.ac.del.rental.Discountable;
import id.ac.del.rental.FlashSaleDiscount;
import id.ac.del.rental.MemberDiscount;
import id.ac.del.rental.VehicleRental;

/**
 *
 * @author Gaudium
 */

public class TestRental {
    public static void main(String[] args) {
        // Buat objek rental: plat BK 1234 DEL, tarif 250000 per hari.
        VehicleRental v = new VehicleRental("BK 1234 DEL", 250000);

        // Lama sewa 7 hari (valid, lewat setter yang memvalidasi).
        v.setRentalDays(7);

        // ----- BAGIAN C NO.3: kirim objek diskon yang BERBEDA-BEDA saat runtime -----
        // Tipe variabel = Discountable (interface), objek aslinya macam-macam (polimorfisme).
        Discountable member = new MemberDiscount();       // 10%
        Discountable flash = new FlashSaleDiscount();     // 25%
        Discountable corporate = new CorporateDiscount(); // 15%

        System.out.println("Plat nomor   : " + v.getPlateNumber());

        // Tanpa diskon: 250000 * 7 = 1750000.
        System.out.println("Tanpa diskon : Rp" + v.getTotalCost());

        // Dengan diskon member: 1750000 - 10% = 1575000.
        System.out.println("Member       : Rp" + v.getTotalCost(member));

        // Dengan diskon flash sale: 1750000 - 25% = 1312500.
        System.out.println("Flash Sale   : Rp" + v.getTotalCost(flash));

        // Dengan diskon korporat: 1750000 - 15% = 1487500.
        System.out.println("Corporate    : Rp" + v.getTotalCost(corporate));
 
        // ----- Bukti perbaikan no.2: input tidak valid sekarang DITOLAK -----
        try {
            // Baris D versi asli: sebelumnya lolos, sekarang melempar exception.
            v.setRentalDays(-7);
        } catch (IllegalArgumentException e) {
            // Tangkap exception dan tampilkan pesannya.
            System.out.println("[Error] " + e.getMessage());
        }

        // Baris A, B, C versi asli (kalau tanda // dihapus, SEMUANYA error karena kini private):
        // v.plateNumber = "";            // Baris A
        // v.rentalRatePerDay = -500000;  // Baris B
        // v.discountRate = 0.20;         // Baris C
    }
}



/*
 * =====================================================================================
 * BAGIAN C NO.1 - ANALISIS KOMPILASI DAN HAK AKSES  (jawaban ada di komentar ini)
 * =====================================================================================
 *
 * Konteks: class ini ada di package id.ac.del.test, sedangkan VehicleRental (kode ASLI soal)
 * ada di package id.ac.del.rental, dan TestRental BUKAN subclass VehicleRental.
 * Artinya TestRental adalah "orang luar" bagi VehicleRental.
 *
 * Kode ASLI soal dan hasilnya:
 *
 *   Baris A:  v.plateNumber = "";           -> plateNumber berstatus public
 *             HASIL: BISA dikompilasi. public boleh diakses dari mana saja.
 *
 *   Baris B:  v.rentalRatePerDay = -500000; -> rentalRatePerDay berstatus protected
 *             HASIL: COMPILE-TIME ERROR. protected hanya bisa diakses dari package yang sama
 *             ATAU dari subclass. TestRental beda package dan bukan subclass.
 *
 *   Baris C:  v.discountRate = 0.20;        -> discountRate TANPA modifier (default / package-private)
 *             HASIL: COMPILE-TIME ERROR. default hanya bisa diakses dari package yang sama.
 *             TestRental beda package.
 *
 *   Baris D:  v.setRentalDays(-7);          -> method setRentalDays berstatus public
 *             HASIL: BISA dikompilasi (walaupun nilai -7 tidak masuk akal, lihat jawaban no.2).
 *
 *   JAWABAN: Baris B dan Baris C yang memicu compile-time error.
 *
 * Aturan cakupan akses (apakah bisa diakses dari ...):
 *
 *   Modifier          | class yang sama | package yang sama | subclass beda package | semua class
 *   ------------------+-----------------+-------------------+-----------------------+------------
 *   public            |       ya        |        ya         |          ya           |     ya
 *   protected         |       ya        |        ya         |   ya (lewat pewarisan)|    tidak
 *   default (kosong)  |       ya        |        ya         |         tidak         |    tidak
 *   private           |       ya        |       tidak       |         tidak         |    tidak
 *
 * Catatan: pada versi refaktor, SEMUA atribut private, jadi Baris A, B, dan C sama-sama error
 * kalau dipanggil langsung. Itu memang tujuannya: data hanya boleh diubah lewat setter bervalidasi.
 *

 * =====================================================================================
 * BAGIAN C NO.2 - KELEMAHAN INTEGRITAS DATA  (jawaban ada di komentar ini)
 * =====================================================================================
 *
 * 2 i) Cacat logika pada setRentalDays (kode ASLI soal):
 *
 *        public void setRentalDays(int days) {
 *            this.rentalDays = days;      // <- langsung disimpan, TANPA pemeriksaan apa pun
 *        }
 *
 *      Method ini memang "setter", tetapi setter yang tidak memvalidasi tidak melindungi apa-apa.
 *      Baris D memanggil v.setRentalDays(-7), dan nilai -7 (atau 0) diterima begitu saja,
 *      padahal lama sewa tidak masuk akal kalau negatif atau nol (minimal 1 hari).
 *      Jadi: memakai setter saja BELUM cukup, setter harus berisi aturan (if).
 *
 *      Baris A (v.plateNumber = "") lebih buruk lagi: plateNumber berstatus public, sehingga
 *      bisa diisi apa saja, termasuk string kosong, tanpa melewati method apa pun.
 *
 * 2 ii) Mengapa total biaya bisa NEGATIF, dan cara refaktornya:
 *
 *      Rumus asli: (rate * hari) - (rate * hari * discountRate)
 *
 *      Penyebab total negatif:
 *        1. rentalDays = -7 diterima (setter tanpa validasi)  ->  250000 * -7 = -1.750.000.
 *        2. rentalRatePerDay bisa diisi -500000 dari luar (protected tanpa validasi).
 *        3. discountRate bisa diisi 1.5 atau lebih (tidak dibatasi 0..1)  ->  potongan > harga.
 *      Semua data keuangan ini bisa diubah dari luar tanpa pemeriksaan = data corruption.
 *
 *      Cara refaktor (sudah diterapkan di class di bawah):
 *        a) Semua atribut dijadikan PRIVATE (data hiding).
 *        b) Akses lewat getter / setter yang MEMVALIDASI:
 *             plat tidak boleh kosong, tarif > 0, hari >= 1.
 *        c) Validasi juga di CONSTRUCTOR, agar objek tidak pernah lahir dalam keadaan rusak.
 *        d) Input salah ditolak dengan IllegalArgumentException.
 *        e) Atribut discountRate dihapus; diskon diserahkan ke interface Discountable (no.3),
 *           dan potongan dibatasi maksimal sebesar subtotal sehingga total tidak pernah negatif.
 */