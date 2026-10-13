/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemPertahananHogwarts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaudium
 */
// Abstract class: kerangka untuk semua mantra perlindungan
abstract class MantraPerlindungan {
    private String nama;
    protected boolean aktif; // status mantra: true = aktif, false = mati

    public MantraPerlindungan(String nama) {
        this.nama = nama;
        this.aktif = false; // awalnya semua mantra belum aktif
    }

    public String getNama() {
        return nama;
    }

    public boolean isAktif() {
        return aktif;
    }

    // Abstract method: tiap mantra punya cara aktif dan mati sendiri-sendiri
    public abstract void aktifkan();
    public abstract void nonaktifkan();
}

// Protego: perisai pelindung
class Protego extends MantraPerlindungan {
    public Protego() {
        super("Protego");
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Perisai Protego terbentuk!");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Perisai Protego menghilang.");
    }
}

// Fidelius: butuh penyihir yang menjadi Secret Keeper (penjaga rahasia)
class Fidelius extends MantraPerlindungan {
    private String secretKeeper; // nama penyihir penjaga rahasia

    public Fidelius(String secretKeeper) {
        super("Fidelius");
        this.secretKeeper = secretKeeper;
    }

    @Override
    public void aktifkan() {
        // Tanpa Secret Keeper, mantra ini tidak bisa aktif
        if (secretKeeper == null || secretKeeper.isEmpty()) {
            System.out.println("Fidelius gagal: Secret Keeper belum ditentukan!");
            return;
        }
        aktif = true;
        System.out.println("Mantra Fidelius aktif. Rahasia disembunyikan di dalam jiwa "
                + secretKeeper + " (Secret Keeper).");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Mantra Fidelius dicabut. Rahasia tidak lagi tersembunyi.");
    }
}

// MantraAntiApparition: mencegah apparition (teleportasi) di area tertentu
class MantraAntiApparition extends MantraPerlindungan {
    private String area; // area yang dilindungi

    public MantraAntiApparition(String area) {
        super("Anti-Apparition");
        this.area = area;
    }

    @Override
    public void aktifkan() {
        aktif = true;
        System.out.println("Anti-Apparition aktif: tidak ada yang bisa ber-apparate di area " + area + ".");
    }

    @Override
    public void nonaktifkan() {
        aktif = false;
        System.out.println("Anti-Apparition nonaktif: apparition kembali diizinkan di area " + area + ".");
    }
}

// SistemPertahanan: menampung banyak mantra perlindungan sekaligus
public class SistemPertahanan {
    private List<MantraPerlindungan> daftarMantra = new ArrayList<>();

    // Menambahkan mantra ke sistem (mantra jenis apa pun boleh, asal turunan MantraPerlindungan)
    public void tambahMantra(MantraPerlindungan mantra) {
        daftarMantra.add(mantra);
        System.out.println("Mantra " + mantra.getNama() + " ditambahkan ke sistem pertahanan.");
    }

    // Mengaktifkan semua mantra. Java otomatis memanggil aktifkan() sesuai jenis mantranya
    public void aktifkanSemuaMantra() {
        System.out.println("\n=== Mengaktifkan semua mantra ===");
        for (MantraPerlindungan m : daftarMantra) {
            m.aktifkan();
        }
    }

    // Menonaktifkan semua mantra
    public void nonaktifkanSemuaMantra() {
        System.out.println("\n=== Menonaktifkan semua mantra ===");
        for (MantraPerlindungan m : daftarMantra) {
            m.nonaktifkan();
        }
    }
    
        public static void main(String[] args) {
        // Membuat sistem pertahanan Hogwarts
        SistemPertahanan hogwarts = new SistemPertahanan();

        // Membuat beberapa objek mantra
        MantraPerlindungan protego = new Protego();
        MantraPerlindungan fidelius = new Fidelius("Peter Pettigrew");
        MantraPerlindungan antiApparition = new MantraAntiApparition("Hogwarts");

        // Menambahkan mantra ke sistem pertahanan
        hogwarts.tambahMantra(protego);
        hogwarts.tambahMantra(fidelius);
        hogwarts.tambahMantra(antiApparition);

        // Aktifkan semua, lalu matikan semua
        hogwarts.aktifkanSemuaMantra();
        hogwarts.nonaktifkanSemuaMantra();
    }
}




/*=============================================================
    Penjelasan Program (Tantangan)
    - MantraPerlindungan adalah abstract class. Isinya aturan: setiap mantra
      perlindungan wajib punya method aktifkan() dan nonaktifkan().
    - Protego, Fidelius, dan MantraAntiApparition adalah class turunannya. Masing-masing
      mengisi aktifkan() dan nonaktifkan() dengan cara yang beda.
    - Fidelius butuh nama Secret Keeper. Kalau nama kosong, mantranya gagal aktif.
    - SistemPertahanan menyimpan semua mantra dalam satu daftar bertipe
      MantraPerlindungan. Ini contoh polymorphism: saat aktifkanSemuaMantra() jalan,
      Java otomatis memanggil aktifkan() milik Protego, Fidelius, atau Anti-Apparition
      sesuai objeknya.
    - Kalau mau menambah mantra baru (misalnya Cave Inimicum), cukup bikin class
      baru yang extends MantraPerlindungan. Class SistemPertahanan tidak perlu diubah.
*/
