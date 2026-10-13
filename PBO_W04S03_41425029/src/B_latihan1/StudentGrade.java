/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B_latihan1;

/**
 *
 * @author Gaudium
 */
public class StudentGrade {
    // kunci atribut dengan hak akses private = ubah modifier private
    private String nim;
    private String nama;
    private double nilaiKuis;
    private double nilaiUTS;
    private String gradeHuruf;
    
    // Constructor StudentGrade dulu
    public StudentGrade(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        
    // Nilai awal dibuat 0.0 (eksplisit supaya jelas).
        this.nilaiKuis = 0.0;
        this.nilaiUTS = 0.0;
        
        // Hitung grade awal supaya gradeHuruf tidak kosong (null).
        updateGradeHuruf();

        // Pesan registrasi sesuai contoh output di modul.
        System.out.println("[Registrasi] Berhasil mendaftarkan mahasiswa: " + nim + " - " + nama);
    }        
    // ===== GETTER (hanya MEMBACA, tanpa if, tanpa parameter) =====
    // Getter NIM. Karena tidak ada setNim(), NIM tidak bisa diubah dari luar class.
    public String getNim() {
        return nim;
    }

    // Getter nama. Tidak ada setNama(), jadi read-only.
    public String getNama() {
        return nama;
    }

    // Getter nilai kuis. Tipe kembalian double sama dengan tipe atributnya.
    public double getNilaiKuis() {
        // Cukup tulis nama variabelnya, jangan tulis tipe lagi.
        return nilaiKuis;
    }

    // Getter nilai UTS.
    public double getNilaiUTS() {
        return nilaiUTS;
    }

    // Getter grade huruf. Tidak ada setGradeHuruf(), jadi tidak bisa di-set dari luar.
    public String getGradeHuruf() {
        return gradeHuruf;
    }

    // ===== SETTER (MENGUBAH nilai, di sini validasi dilakukan) =====
    // void = tidak mengembalikan nilai. Nilai baru masuk lewat parameter.
    public void setNilaiKuis(double nilaiKuis) {
        // Kondisi untuk nilai SALAH: lebih kecil dari 0.0 ATAU (||) lebih besar dari 100.0.
        if (nilaiKuis < 0.0 || nilaiKuis > 100.0) {
            // Tampilkan pesan kesalahan sesuai contoh output.
            System.out.println("[Error] Nilai kuis tidak valid: " + nilaiKuis + " (Harus antara 0 - 100)");

            // return menghentikan method SEKARANG, sehingga baris simpan di bawah tidak dijalankan.
            // Tanpa return, nilai salah tetap tersimpan (bug paling umum).
            return;
        }

        // Sampai sini berarti nilai valid, simpan ke atribut (this. = atribut, tanpa this. = parameter).
        this.nilaiKuis = nilaiKuis;

        // Pesan sukses.
        System.out.println("[Update] Nilai kuis berhasil diubah menjadi: " + nilaiKuis);

        // Nilai berubah, jadi grade harus dihitung ulang secara otomatis.
        updateGradeHuruf();
    }

    // Setter UTS: logikanya sama persis dengan setter kuis.
    public void setNilaiUTS(double nilaiUTS) {
        // Tolak jika di luar rentang 0.0 - 100.0.
        if (nilaiUTS < 0.0 || nilaiUTS > 100.0) {
            System.out.println("[Error] Nilai UTS tidak valid: " + nilaiUTS + " (Harus antara 0 - 100)");
            return;
        }

        // Valid, simpan.
        this.nilaiUTS = nilaiUTS;

        System.out.println("[Update] Nilai UTS berhasil diubah menjadi: " + nilaiUTS);

        // Hitung ulang grade.
        updateGradeHuruf();
    }

    // ===== METHOD PERHITUNGAN =====
    // Nilai akhir = 40% kuis + 60% UTS. Tidak disimpan di atribut karena bisa dihitung kapan saja
    // dari dua nilai di atas (menyimpannya justru berisiko tidak sinkron).
    public double hitungNilaiAkhir() {
        return (0.4 * nilaiKuis) + (0.6 * nilaiUTS);
    }

    // Method private: hanya bisa dipanggil dari DALAM class ini (bukan dari Main).
    // Inilah cara gradeHuruf terisi otomatis tanpa setter publik.
    private void updateGradeHuruf() {
        // Ambil nilai akhir terbaru.
        double akhir = hitungNilaiAkhir();

        // Tentukan grade dari yang tertinggi ke terendah.
        if (akhir >= 85) {
            gradeHuruf = "A";
        } else if (akhir >= 70) {
            gradeHuruf = "B";
        } else if (akhir >= 55) {
            gradeHuruf = "C";
        } else if (akhir >= 40) {
            gradeHuruf = "D";
        } else {
            gradeHuruf = "E";
        }
    }

    // ===== LAPORAN =====
    // Mencetak kartu hasil studi sesuai contoh output.
    public void cetakLaporan() {
        System.out.println("=== KARTU HASIL STUDI ===");
        System.out.println("NIM        : " + nim);
        System.out.println("Nama       : " + nama);
        System.out.println("Nilai Kuis : " + nilaiKuis);
        System.out.println("Nilai UTS  : " + nilaiUTS);
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
        // Baris tambahan untuk Tantangan (gradeHuruf).
        System.out.println("Grade      : " + gradeHuruf);
    }
}
        