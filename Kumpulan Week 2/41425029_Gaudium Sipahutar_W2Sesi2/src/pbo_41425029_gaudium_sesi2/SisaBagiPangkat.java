/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo_41425029_gaudium_sesi2;

import java.util.Scanner;
/*
 * NIM : 41425029
 * Nama: Gaudium Sipahutar
 * Motto: Want be the best on my future
 */

public class SisaBagiPangkat {
    public static void main(String[] args) {
        // Inisialisasi Scanner untuk membaca masukan dari pengguna
        Scanner input = new Scanner(System.in);
        // Membaca dua bilangan bulat
        System.out.print("Masukkan angka pertama: ");
        int angka1 = input.nextInt();
        System.out.print("Masukkan angka kedua: ");
        int angka2 = input.nextInt();
        // Melakukan operasi sisa bagi (%) dan perpangkatan (Math.pow)
        int sisaBagi = angka1 % angka2;
        double pangkat = Math.pow(angka1, angka2);
        // Menampilkan hasil operasi
        System.out.println("Sisa bagi: " + sisaBagi);
        System.out.println("Pangkat: " + (long) pangkat);
        // Menutup objek scanner
        input.close();
    }
}
