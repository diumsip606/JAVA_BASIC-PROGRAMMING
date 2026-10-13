package MethodOverloading;

import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 * 
 */
public class Mantra {
    // Method ucapkan() dengan satu parameter
    public void ucapkan(String namaMantra){
        System.out.println("Mengucapkan mantra: " + namaMantra);
    }
    
    // Overload: method ucapkan() dengan dua parameter
    public void ucapkan(String namaMantra, int kekuatan) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10){
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: Senjata terlepas.");
        }
    }

    // Overload: method ucapkan() dengan tiga parameter
    public void ucapkan(String namaMantra, int kekuatan, String target) {
        System.out.println("Mengucapkan mantra: " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10){
            System.out.println("Efek: " + target + " terlempar!");
        } else {
            System.out.println("Efek: Senjata " + target + " terlepas.");
        }
    }
    
    public static void main(String[] args){
        Mantra mantra = new Mantra();
        mantra.ucapkan("Expelliarmus");
        mantra.ucapkan("Expelliarmus", 5);
        mantra.ucapkan("Expelliarmus", 15, "Voldemort");
    }
}

/* =============================================================
    Pertanyaan Method Overloading
    1. Apa yang terjadi jika kita menghapus salah satu method overloading? Misalnya, method 
    dengan dua parameter.
    Program pada void main jadi error karena mantra.ucapkan("Expelliarmus", 5);
    method dengan 2 parameternya tidak ada yaitu (String namaMantra, int kekuatan).
    
    2. Bisakah kita membuat method overloading dengan urutan parameter yang berbeda? Coba 
    buat method ucapkan(int kekuatan, String namaMantra).
    Bisa. Method boleh punya nama yang sama asal parameternya beda. Urutan parameter
    yang dituker juga dihitung beda.

    Contoh:
    - ucapkan(String namaMantra, int kekuatan)  -> String dulu, baru int
    - ucapkan(int kekuatan, String namaMantra)  -> int dulu, baru String

    Dua method itu dianggap berbeda oleh Java, jadi tidak error. Saat dipanggil,
    Java melihat urutan data yang dikirim:
    - mantra.ucapkan("Expelliarmus", 20); -> masuk ke versi (String, int)
    - mantra.ucapkan(20, "Expelliarmus"); -> masuk ke versi (int, String)

    Yang tidak bisa: dua method dengan parameter yang sama persis, walaupun
    nama parameternya beda atau tipe return-nya beda. Itu tetap error karena
    Java menganggap method yang sama.
*/
