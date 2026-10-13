/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_41425029_gaudium.sipahutar_sesi3;

import java.util.Scanner;

/*
 * NIM : 41425029
 * Nama: Gaudium Sipahutar
 * Motto: Want be the best on my future
 */

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Konverter Waktu ===");
        System.out.println("1. Detik ke HH:MM:SS");
        System.out.println("2. HH:MM:SS ke detik");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer enter

        if (pilihan == 1) {
            System.out.print("Masukkan jumlah detik: ");
            int totalDetik = scanner.nextInt();

            // Perhitungan jam, menit, dan detik
            int jam = totalDetik / 3600;
            int sisaDetik = totalDetik % 3600;
            int menit = sisaDetik / 60;
            int detik = sisaDetik % 60;

            // Format tampilan agar 2 digit (HH:MM:SS)
            System.out.printf("Hasil: %02d:%02d:%02d\n", jam, menit, detik);

        } else if (pilihan == 2) {
            System.out.print("Masukkan waktu (HH:MM:SS): ");
            String waktuInput = scanner.nextLine();

            // Pemisahan string berdasarkan karakter ':'
            String[] bagian = waktuInput.split(":");

            if (bagian.length == 3) {
                int jam = Integer.parseInt(bagian[0]);
                int menit = Integer.parseInt(bagian[1]);
                int detik = Integer.parseInt(bagian[2]);

                // Perhitungan total detik
                int totalDetik = (jam * 3600) + (menit * 60) + detik;
                System.out.println("Hasil: " + totalDetik + " detik");
            } else {
                System.out.println("Format waktu tidak valid! Gunakan format HH:MM:SS.");
            }

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}