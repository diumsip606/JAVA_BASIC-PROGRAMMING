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

public class DataDiri_1 {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input dinamis dari pengguna
        Scanner input = new Scanner(System.in);
        // Membaca masukan nama, umur, tinggi badan, dan status mahasiswa
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Umur: ");
        int umur = input.nextInt();
        System.out.print("Masukkan Tinggi Badan (cm): ");
        double tinggi = input.nextDouble();
        System.out.print("Status Mahasiswa (true/false): ");
        boolean isMahasiswa = input.nextBoolean();
        // Menampilkan data yang telah diinput pengguna
        System.out.println("\n--- Data Diri ---");
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " tahun");
        System.out.println("Tinggi: " + tinggi + " cm");
        System.out.println("Status Mahasiswa: " + isMahasiswa);
        // Melakukan explicit casting dari tipe double ke int untuk pembulatan
        int tinggiBulat = (int) tinggi;
        System.out.println("Tinggi (dibulatkan): " + tinggiBulat + " cm");
        // Menutup objek scanner
        input.close();
    }
}