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

public class AnalisisKata {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan kata/kalimat: ");
        String teks = input.nextLine();
        // 1. Cek Palindrome (mengabaikan spasi dan kapitalisasi huruf)
        String teksBersih = teks.replaceAll("\\s+", "").toLowerCase();
        String balikTeks = new StringBuilder(teksBersih).reverse().toString();
        boolean isPalindrome = teksBersih.equals(balikTeks);
        // 2. Menghitung jumlah huruf vokal (a, e, i, o, u)
        int jumlahVokal = 0;
        String teksLower = teks.toLowerCase();
        for (int i = 0; i < teksLower.length(); i++) {
            char c = teksLower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                jumlahVokal++;
            }
        }
        // Menampilkan output hasil analisis
        System.out.println("\n--- Hasil Analisis ---");
        System.out.println("Apakah Palindrome? " + (isPalindrome ? "Ya" : "Tidak"));
        System.out.println("Jumlah huruf vokal: " + jumlahVokal);
        input.close();
    }
}