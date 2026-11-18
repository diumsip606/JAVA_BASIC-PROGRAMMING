/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1_STRING_MANIPULATION;
import java.util.*;
/**
 *
 * @author Gaudium
 */
public class StringManipulationModifikasi {
     public static int countVowels(String s) {
        int count = 0;                 // penghitung, mulai dari 0
        String vowels = "aeiou";       // daftar vokal; sengaja huruf kecil semua

        // s.toLowerCase()  : ubah teks jadi huruf kecil, agar 'A' dan 'a' dianggap sama
        //                    (kita cukup membandingkan dengan daftar huruf kecil).
        // .toCharArray()   : pecah String menjadi array karakter (char[]),
        //                    sehingga bisa diperiksa satu per satu.
        // for (char c : ...): ulangi untuk setiap karakter, 'c' = karakter saat ini.
        for (char c : s.toLowerCase().toCharArray()) {

            // vowels.indexOf(c) mencari posisi c di dalam "aeiou".
            //  - jika c adalah vokal -> hasilnya 0 sampai 4 (ketemu)
            //  - jika c bukan vokal  -> hasilnya -1 (tidak ketemu)
            // Jadi "!= -1" berarti "c adalah vokal".
            // Spasi, tanda baca, dan konsonan otomatis tidak dihitung.
            if (vowels.indexOf(c) != -1) {
                count++;               // vokal ketemu, tambah 1
            }
        }
        return count;                  // kembalikan total vokal
    }

    // ============================================================
    // MAIN: titik awal program, memanggil kedua modifikasi
    // ============================================================
    public static void main(String[] args) {
        // Teks sama dengan praktikum (ada 2 spasi di depan dan belakang)
        String text = "  Hello World! Welcome to Java Programming  ";

        // trim() membuang spasi tepi, lalu split(" ") memecah di setiap spasi.
        // Hasil: ["Hello", "World!", "Welcome", "to", "Java", "Programming"]
        String[] words = text.trim().split(" ");

        // ---------------------------------------------------------
        // MODIFIKASI 1: tampilkan hanya kata dengan panjang > 4 karakter
        // ---------------------------------------------------------
        System.out.println("=== KATA DENGAN PANJANG > 4 ===");

        // Ulangi untuk setiap kata di array 'words'
        for (String word : words) {

            // replaceAll(regex, pengganti): mengganti semua bagian yang cocok dengan pola.
            // Pola "[^a-zA-Z]" artinya "karakter apa pun yang BUKAN huruf"
            // (tanda ^ di dalam [ ] berarti 'bukan'). Semua yang cocok diganti "" (dihapus).
            // Alasannya: "World!" kalau dihitung apa adanya panjangnya 6 karena
            // tanda '!' ikut terhitung. Setelah dibersihkan jadi "World" (5 huruf).
            String clean = word.replaceAll("[^a-zA-Z]", "");

            // Syarat modifikasi: hanya kata yang panjangnya LEBIH DARI 4 yang ditampilkan.
            // "to" (2) dan "Java" (4) tidak lolos karena 4 tidak lebih dari 4.
            if (clean.length() > 4) {
                System.out.println(clean + " (" + clean.length() + " karakter)");
            }
        }

        // ---------------------------------------------------------
        // MODIFIKASI 2: memanggil method countVowels
        // ---------------------------------------------------------
        System.out.println("\n=== JUMLAH HURUF VOKAL ===");
        System.out.println("Teks  : '" + text.trim() + "'");

        // Memanggil method yang dibuat di atas, hasilnya langsung dicetak.
        // Rincian vokal: Hello(2) World(1) Welcome(3) to(1) Java(2) Programming(3) = 12
        System.out.println("Vokal : " + countVowels(text));
    }
}
