/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.rental;

/**
 *
 * @author Gaudium
 */

public class VehicleRental {

    // ===== ATRIBUT: semua private (perbaikan 2 ii-a) =====
    // Plat nomor kendaraan.
    private String plateNumber;

    // Tarif sewa per hari (rupiah).
    private double rentalRatePerDay;

    // Lama sewa dalam hari.
    private int rentalDays;

    // ===== CONSTRUCTOR =====
    // Memakai setter di dalam constructor supaya aturan validasi yang sama ikut berlaku.
    public VehicleRental(String plateNumber, double rate) {
        // Validasi plat lewat setter.
        setPlateNumber(plateNumber);

        // Validasi tarif lewat setter.
        setRentalRatePerDay(rate);
    }

    // ===== PLAT NOMOR =====
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        // Tolak null atau teks kosong / hanya spasi. trim() membuang spasi di awal dan akhir.
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            // throw = hentikan dan laporkan kesalahan. Objek tidak jadi diubah.
            throw new IllegalArgumentException("Plat nomor tidak boleh kosong!");
        }
        this.plateNumber = plateNumber;
    }

    // ===== TARIF PER HARI =====
    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public void setRentalRatePerDay(double rate) {
        // Tarif harus lebih dari 0. Tarif negatif seperti -500000 (Baris B) kini ditolak.
        if (rate <= 0) {
            throw new IllegalArgumentException("Tarif per hari harus lebih dari 0!");
        }
        this.rentalRatePerDay = rate;
    }

    // ===== LAMA SEWA =====
    public int getRentalDays() {
        return rentalDays;
    }

    // Ini perbaikan untuk cacat di soal 2 i: setter sekarang MEMVALIDASI.
    public void setRentalDays(int days) {
        // Minimal 1 hari. Nilai -7 (Baris D) atau 0 ditolak.
        if (days < 1) {
            throw new IllegalArgumentException("Lama sewa minimal 1 hari!");
        }
        this.rentalDays = days;
    }

    // ===== TOTAL BIAYA =====
    // Versi tanpa diskon.
    public double getTotalCost() {
        return rentalRatePerDay * rentalDays;
    }

    /*
     * BAGIAN C NO.3 (ii) - getTotalCost() menerima parameter bertipe interface Discountable.
     *
     * Parameter bertipe INTERFACE, bukan class tertentu. Objek diskon asli (MemberDiscount,
     * FlashSaleDiscount, CorporateDiscount, ...) dikirim dari TestRental saat program berjalan (runtime).
     * Method calculateDiscount yang dijalankan ditentukan oleh objek yang dikirim = polimorfisme.
     * VehicleRental tidak perlu tahu jenis diskonnya, sehingga skema diskon baru bisa ditambah
     * tanpa mengubah class ini (dependency injection).
     */
    public double getTotalCost(Discountable discount) {
        // Harga sebelum diskon.
        double subtotal = rentalRatePerDay * rentalDays;

        // Minta objek diskon menghitung potongannya (perilaku tergantung objek yang dikirim).
        double potongan = discount.calculateDiscount(subtotal);

        // Pengaman: potongan tidak boleh melebihi harga, agar total tidak pernah negatif.
        if (potongan > subtotal) {
            potongan = subtotal;
        }

        // Total akhir = harga - potongan.
        return subtotal - potongan;
    }
}
