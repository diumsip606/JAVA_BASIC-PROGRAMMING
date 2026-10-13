/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B_latihan1;

/**
 *
 * @author Gaudium
 */

public class Main {
    public static void main(String[] args) {
        // Buat objek mahasiswa. Constructor otomatis mencetak pesan registrasi.
        StudentGrade mhs = new StudentGrade("11425001", "Marsha");

        // 110.0 di luar rentang 0-100, harus DITOLAK dan memunculkan pesan error.
        mhs.setNilaiKuis(110.0);

        // 85.0 valid, harus DITERIMA.
        mhs.setNilaiKuis(85.0);

        // 90.0 valid untuk UTS.
        mhs.setNilaiUTS(90.0);

        // Cetak kartu hasil studi (nilai akhir 0.4*85 + 0.6*90 = 88.0, grade A).
        mhs.cetakLaporan();

        // Bukti encapsulation: baris-baris di bawah ERROR kompilasi kalau tanda // dihapus,
        // karena atributnya private dan tidak ada setter untuk NIM / gradeHuruf.
        // mhs.nilaiKuis = 500;       // private, tidak bisa diakses langsung
        // mhs.nim = "999";           // private
        // mhs.gradeHuruf = "A";      // private
        // mhs.setNim("999");         // method ini tidak ada (read-only)
    }
}
