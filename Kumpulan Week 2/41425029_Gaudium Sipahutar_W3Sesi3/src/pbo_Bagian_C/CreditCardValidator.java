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

public class CreditCardValidator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan nomor kartu: ");
            String inputCard = scanner.nextLine().trim();
            
            // Mentransfer string tanpa tanda hubung untuk pengecekan total digit
            String rawCard = inputCard.replace("-", "");
            
            // Validasi 1: Harus terdiri dari 16 digit angka
            if (!rawCard.matches("\\d{16}")) {
                System.out.println("Nomor kartu tidak valid!");
                System.out.println("Harus berjumlah 16 digit angka.");
                scanner.close();
                return;
            }
            
            // Validasi 2: Jika menggunakan tanda hubung, format harus per 4 digit
            if (inputCard.contains("-")) {
                if (!inputCard.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
                    System.out.println("Nomor kartu tidak valid!");
                    System.out.println("Format tanda hubung harus tepat 4 digit sekali (XXXX-XXXX-XXXX-XXXX).");
                    scanner.close();
                    return;
                }
            }
            
            // Validasi 3: Harus dimulai dengan angka 4, 5, atau 6
            char firstDigit = rawCard.charAt(0);
            if (firstDigit != '4' && firstDigit != '5' && firstDigit != '6') {
                System.out.println("Nomor kartu tidak valid!");
                System.out.println("Harus dimulai dengan 4, 5, atau 6.");
                scanner.close();
                return;
            }
            
            // Jika memenuhi semua kriteria validasi
            System.out.println("Nomor kartu valid.");
        }
    }
}