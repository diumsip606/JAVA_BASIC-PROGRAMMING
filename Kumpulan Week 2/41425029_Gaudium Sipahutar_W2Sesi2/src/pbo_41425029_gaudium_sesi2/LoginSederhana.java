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

public class LoginSederhana {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Membaca masukan username dan password
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        // Validasi: username "admin", password minimal 6 karakter & mengandung angka
        boolean isValidUsername = username.equals("admin");
        boolean isValidPassword = password.length() >= 6 && password.matches(".*\\d.*");
        if (isValidUsername && isValidPassword) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal! Password tidak valid.");
        }
        input.close();
    }
}