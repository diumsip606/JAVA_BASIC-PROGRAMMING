/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MethodOverriding;
import java.util.*;
/**
 *
 * @author Gaudium
 */
class Penyihir {
    public void ucapkanMantra(){
        System.out.println("Mengucapkan mantra dengan cara biasa.");
    }
}

class HarryPotter extends Penyihir {
@Override
    public void ucapkanMantra(){
        System.out.println("Harry Potter mengucapkan mantra dengan tongkatnya yang unik.");
    }
}

class Hermione extends Penyihir {
@Override
    public void ucapkanMantra(){
        System.out.println("Hermione mengucapkan mantra dengan tepat dan percaya diri.");
    }
}

// Subclass baru instruksi no. 2: Ron Weasley mengoverride ucapkanMantra() dengan gaya Ron
class RonWeasley extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Ron Weasley mengucapkan mantra dengan gugup, tongkatnya sedikit bergetar.");
    }
}

public class DemoPenyihir {
    public static void main (String[] args){
        Penyihir penyihir1 = new HarryPotter();
        Penyihir penyihir2 = new Hermione();
        Penyihir penyihir3 = new RonWeasley();
        
        penyihir1.ucapkanMantra(); // Output: Harry Potter mengucapkan mantra dengan tongkatnya yang unik.
        penyihir2.ucapkanMantra(); // Output: Hermione mengucapkan mantra dengan tepat dan percaya diri.
        penyihir3.ucapkanMantra(); // Output: Ron Weasley mengucapkan mantra dengan gugup, tongkatnya sedikit bergetar.
    }
}

/* =============================================================
 Pertanyaan Method Overriding
    1. Apa yang terjadi jika kita tidak menggunakan annotation @Override? Apakah kode
    masih berjalan?
    Kode tetap berjalan seperti biasa dan hasilnya sama. @Override itu cuma penanda
    untuk Java, bukan syarat supaya overriding bisa jalan.

    Tapi @Override tetap berguna sebagai pengaman. Misalnya kita salah ketik nama
    method jadi ucapkanMantr() atau salah parameter:
    - Pakai @Override -> Java langsung kasih error, jadi salahnya ketahuan.
    - Tanpa @Override -> Java menganggapnya method baru, jadi method milik induk
      yang tetap jalan dan kita tidak sadar ada salah ketik.

    2. Apa keuntungan menggunakan polymorphism dalam contoh ini?
    - Cukup pakai satu tipe, yaitu Penyihir, untuk semua penyihir. Tidak perlu
      bikin variabel berbeda untuk Harry, Hermione, dan Ron.
    - Gampang menambah penyihir baru. Tadi Ron ditambahkan tanpa mengubah kode
      yang sudah ada.
    - Tidak perlu if/else untuk mengecek "ini penyihir yang mana". Java otomatis
      menjalankan method yang sesuai dengan objeknya.
    - Praktis kalau penyihirnya banyak, misalnya dimasukkan ke satu array atau list
      lalu dipanggil ucapkanMantra() satu per satu.
*/