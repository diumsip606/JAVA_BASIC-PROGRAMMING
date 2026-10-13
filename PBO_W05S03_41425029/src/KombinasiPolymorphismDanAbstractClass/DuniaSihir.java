/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KombinasiPolymorphismDanAbstractClass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaudium
 */
abstract class Mantra {
    private String nama;

    public Mantra(String nama) {
        this.nama = nama;
    }

    // Getter supaya nama mantra bisa dibaca dari class lain
    public String getNama() {
        return nama;
    }

    // Abstract method untuk efek mantra, diisi oleh tiap subclass
    public abstract void efek();
}

class Expelliarmus extends Mantra {
    public Expelliarmus() {
        super("Expelliarmus");
    }

    @Override
    public void efek() {
        System.out.println("Melucuti senjata lawan!");
    }
}

class ExpectoPatronum extends Mantra {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }

    @Override
    public void efek() {
        System.out.println("Memanggil Patronus!");
    }
}

class Lumos extends Mantra {
    public Lumos() {
        super("Lumos");
    }

    @Override
    public void efek() {
        System.out.println("Menerangi ujung tongkat!");
    }
}

// Class Penyihir: punya daftar mantra yang sudah dipelajari
class Penyihir {
    private String nama;
    private List<Mantra> mantraList; // bisa diisi mantra jenis apa saja

    public Penyihir(String nama) {
        this.nama = nama;
        this.mantraList = new ArrayList<>();
    }

    // Penyihir belajar mantra baru (dimasukkan ke daftar)
    public void belajarMantra(Mantra mantra) {
        mantraList.add(mantra);
        System.out.println(nama + " belajar mantra: " + mantra.getNama());
    }

    // Mengucapkan satu mantra berdasarkan namanya
    public void ucapkanMantra(String namaMantra) {
        for (Mantra mantra : mantraList) {
            if (mantra.getNama().equals(namaMantra)) {
                System.out.println(nama + " mengucapkan: " + mantra.getNama());
                mantra.efek(); // efek yang jalan sesuai jenis mantranya
                return;
            }
        }
        // Kalau mantra tidak ada di daftar
        System.out.println(nama + " belum belajar mantra " + namaMantra);
    }

    // Instruksi no. 2: mengucapkan SEMUA mantra yang sudah dipelajari sekaligus
    public void ucapkanSemuaMantra() {
        if (mantraList.isEmpty()) {
            System.out.println(nama + " belum mempelajari mantra apa pun.");
            return;
        }
        System.out.println(nama + " mengucapkan semua mantranya:");
        for (Mantra mantra : mantraList) {
            System.out.println(nama + " mengucapkan: " + mantra.getNama());
            mantra.efek();
        }
    }
}

public class DuniaSihir {
    public static void main(String[] args) {
        Penyihir harry = new Penyihir("Harry Potter");
        Mantra expelliarmus = new Expelliarmus();
        Mantra expectoPatronum = new ExpectoPatronum();

        harry.belajarMantra(expelliarmus);
        harry.belajarMantra(expectoPatronum);

        harry.ucapkanMantra("Expelliarmus");
        harry.ucapkanMantra("Expecto Patronum");
        harry.ucapkanMantra("Lumos"); // Harry belum belajar Lumos

        // Tambahkan mantra Lumos dan coba lagi
        Mantra lumos = new Lumos();
        harry.belajarMantra(lumos);
        harry.ucapkanMantra("Lumos");

        System.out.println();
        // Memanggil method baru: ucapkan semua mantra sekaligus
        harry.ucapkanSemuaMantra();
    }
}

/*=============================================================
    Pertanyaan Kombinasi Polymorphism dan Abstract Class
    1. Bagaimana polymorphism dan abstract class bekerja sama dalam contoh ini?
    - Abstract class Mantra membuat aturan: semua mantra WAJIB punya method efek().
    - Polymorphism membuat class Penyihir cukup memakai satu tipe, yaitu Mantra,
      untuk semua jenis mantra. Daftarnya (List<Mantra>) bisa diisi Expelliarmus,
      ExpectoPatronum, dan Lumos sekaligus.
    - Saat mantra.efek() dipanggil, Java otomatis menjalankan efek() milik mantra
      yang sebenarnya. Kalau isinya Lumos, yang jalan efek Lumos. Kalau isinya
      Expelliarmus, yang jalan efek Expelliarmus.
    Jadi Penyihir tidak perlu tahu mantranya jenis apa, dan abstract class memastikan
    method efek() pasti ada.

    2. Apa yang akan terjadi jika kita menambahkan mantra baru tanpa mengubah
    kelas Penyihir? Apakah mudah? Mengapa?
    Sangat mudah. Kita cukup bikin class baru yang extends Mantra dan isi method
    efek(), lalu panggil belajarMantra(). Class Penyihir tidak perlu diubah sama
    sekali.

    Alasannya, Penyihir hanya bergantung pada tipe Mantra (yang umum), bukan pada
    mantra tertentu. Buktinya Lumos bisa ditambahkan di main tanpa mengubah Penyihir.
    Prinsip ini namanya Open/Closed Principle: mudah ditambah fitur baru, tanpa
    mengubah kode lama.
*/
