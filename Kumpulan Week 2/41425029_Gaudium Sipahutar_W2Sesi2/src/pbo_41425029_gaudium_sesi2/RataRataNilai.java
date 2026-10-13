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

public class RataRataNilai {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input pengguna
        Scanner input = new Scanner(System.in);
        // Menerima input 3 nilai ujian dari pengguna
        System.out.print("Masukkan nilai 1: ");
        double nilai1 = input.nextDouble();
        System.out.print("Masukkan nilai 2: ");
        double nilai2 = input.nextDouble();
        System.out.print("Masukkan nilai 3: ");
        double nilai3 = input.nextDouble();
        // Menghitung rata-rata dari ketiga nilai
        double rataRata = (nilai1 + nilai2 + nilai3) / 3;
        // Menampilkan hasil rata-rata dengan format dua angka di belakang koma
        System.out.printf("Rata-rata: %.2f\n", rataRata);
        input.close();
    }
}
