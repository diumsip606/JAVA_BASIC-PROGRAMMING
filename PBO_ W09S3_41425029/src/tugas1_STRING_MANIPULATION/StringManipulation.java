/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1_STRING_MANIPULATION;

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        // Ada 2 spasi di depan dan 2 spasi di belakang (disengaja).
        // Inilah kunci jawaban pertanyaan no.1 nanti.
        String text = "  Hello World! Welcome to Java Programming  ";

        // BAGIAN A: OPERASI DASAR
        System.out.println("=== BASIC STRING OPERATIONS ===");
        System.out.println("Original: '" + text + "'");   // tanda kutip ' ' dipakai agar spasi tepi terlihat

        // length(): mengembalikan jumlah karakter (int), SPASI IKUT DIHITUNG.
        // Hasil 44 = 40 karakter isi + 2 spasi depan + 2 spasi belakang.
        System.out.println("Length: " + text.length());

        // trim(): membuang spasi di AWAL dan AKHIR saja (spasi di tengah tetap).
        // Mengembalikan String baru, 'text' tidak berubah.
        System.out.println("Trimmed: '" + text.trim() + "'");

        // toUpperCase(): mengubah semua huruf jadi HURUF BESAR (String baru).
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");

        // toLowerCase(): mengubah semua huruf jadi huruf kecil (String baru).
        System.out.println("Lowercase: '" + text.toLowerCase() + "'");

        // BAGIAN B: SUBSTRING & INDEXING (mengambil / mencari posisi)
        System.out.println("\n=== SUBSTRING & INDEXING ===");

        // charAt(i): mengambil SATU karakter (tipe char) pada indeks i.
        // Indeks 5 = 'l' (indeks 2='H', 3='e', 4='l', 5='l').
        System.out.println("Character at index 5: '" + text.charAt(5) + "'");

        // substring(awal, akhir): mengambil potongan dari indeks 'awal'
        // sampai SEBELUM indeks 'akhir' (indeks akhir TIDAK ikut).
        // substring(7, 12) mengambil indeks 7,8,9,10,11 = ' Worl'
        // (indeks 7 adalah spasi, makanya hasilnya diawali spasi).
        System.out.println("Substring (7-12): '" + text.substring(7, 12) + "'");

        // indexOf(x): mencari posisi KEMUNCULAN PERTAMA x dari kiri.
        // Mengembalikan -1 jika tidak ketemu. "World" mulai di indeks 8.
        System.out.println("Index of 'World': " + text.indexOf("World"));

        // lastIndexOf(x): mencari posisi KEMUNCULAN TERAKHIR x (dicari dari kanan).
        // Huruf 'a' terakhir ada di kata "Programming" (indeks 36).
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));

        // ---------------------------------------------------------
        // BAGIAN C: REPLACE & PERBANDINGAN
        // ---------------------------------------------------------
        System.out.println("\n=== REPLACEMENT & COMPARISON ===");

        // replace(lama, baru): mengganti SEMUA kemunculan 'lama' dengan 'baru'.
        // Mengembalikan String baru; 'text' asli tetap berisi "Java".
        System.out.println("Replace 'Java' with 'Python': '" +
                text.replace("Java", "Python") + "'");

        // contains(x): true jika string mengandung x di posisi mana pun.
        System.out.println("Contains 'Programming': " + text.contains("Programming"));

        // startsWith(x): true jika string DIAWALI x (dicek mulai indeks 0).
        // Hasil FALSE karena indeks 0 adalah spasi, bukan 'H' (lihat Jawaban 1).
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));

        // endsWith(x): true jika string DIAKHIRI x.
        // Hasil FALSE karena string berakhir dengan 2 spasi, bukan huruf 'g'.
        System.out.println("Ends with 'Programming': " + text.endsWith("Programming"));

        
        // BAGIAN D: SPLIT (memecah string jadi array)
        System.out.println("\n=== SPLIT & JOIN ===");

        // split(pemisah): memecah string menjadi array String pada setiap 'pemisah'.
        // trim() dipanggil DULU supaya spasi tepi tidak menghasilkan
        // elemen kosong ("") di awal array.
        // Hasil: ["Hello", "World!", "Welcome", "to", "Java", "Programming"]
        String[] words = text.trim().split(" ");

        // words.length: jumlah elemen array (untuk array pakai .length tanpa tanda kurung,
        // berbeda dengan String yang memakai .length()).
        System.out.println("Number of words: " + words.length);

        System.out.print("Words: ");       // print (bukan println) = tidak pindah baris
        // for-each: mengulang untuk setiap elemen array, 'word' = elemen saat ini.
        for (String word : words) {
            System.out.print("[" + word + "] ");
        }
        System.out.println();              // pindah baris

        
        // BAGIAN E: STRINGBUILDER (string yang BISA diubah langsung)
        System.out.println("\n=== STRING BUILDER ===");

        // Membuat StringBuilder kosong. Berbeda dengan String, objek ini
        // diubah langsung tanpa membuat objek baru tiap perubahan.
        StringBuilder sb = new StringBuilder();

        sb.append("Java");            // append(x): tambah x di AKHIR  -> "Java"
        sb.append(" Programming");    //                               -> "Java Programming"
        sb.insert(0, "Learn ");       // insert(i, x): sisipkan x di indeks i
                                      //                               -> "Learn Java Programming"
        sb.reverse();                 // reverse(): balik urutan seluruh karakter
                                      //                               -> "gnimmargorP avaJ nraeL"

        // toString(): mengubah StringBuilder menjadi String biasa untuk dicetak.
        System.out.println("Reversed: " + sb.toString());
        
        /* PERTANYAAN PRAKTIKUM
         1. Mengapa text.startsWith("Hello") mengembalikan false?
            Karena string text diawali 2 spasi: "  Hello World!...".
            startsWith() membandingkan mulai dari indeks 0, sehingga yang
            dicek adalah ' ' (spasi), bukan 'H'.
            Solusi: panggil trim() dulu -> text.trim().startsWith("Hello")
            akan bernilai true.
            (Alasan yang sama membuat endsWith("Programming") juga false,
            karena ada 2 spasi di akhir string.)
        
         2. Apa perbedaan String dan StringBuilder?
          - String bersifat IMMUTABLE: isinya tidak bisa diubah. Setiap
            modifikasi (replace, trim, concat, dll.) membuat objek BARU.
          - StringBuilder bersifat MUTABLE: isinya diubah langsung pada
            objek yang sama (append, insert, reverse, delete).
          - Jadi StringBuilder jauh lebih efisien (cepat dan hemat memori)
            jika kita sering memodifikasi teks, misalnya di dalam loop.
        
         3. Bagaimana cara mengambil kata "Java" dari string text?
            Cara 1 (indexOf + substring): cari posisi "Java", lalu potong
            sepanjang 4 karakter.
            Cara 2 (split): kata "Java" adalah kata ke-5, yaitu words[4].
            Keduanya didemonstrasikan di bawah ini.
        */
        
        System.out.println("\n=== JAWABAN PERTANYAAN ===");

        // Jawaban 1: bandingkan sebelum dan sesudah trim()
        System.out.println("startsWith('Hello') tanpa trim  : " + text.startsWith("Hello"));        // false
        System.out.println("startsWith('Hello') setelah trim: " + text.trim().startsWith("Hello")); // true

        // Jawaban 3 - cara 1: indexOf + substring
        // Langkah: (1) cari indeks awal "Java", (2) potong dari situ sepanjang 4 huruf.
        // "Java".length() = 4, sehingga substring(start, start + 4) pas mengambil "Java".
        int start = text.indexOf("Java");
        System.out.println("Kata Java (substring): " + text.substring(start, start + "Java".length()));

        // Jawaban 3 - cara 2: lewat array hasil split.
        // Array dimulai dari indeks 0: Hello(0) World!(1) Welcome(2) to(3) Java(4)
        System.out.println("Kata Java (split)    : " + words[4]);
    }
}