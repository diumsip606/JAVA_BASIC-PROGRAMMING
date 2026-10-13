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

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 3;
        boolean isSuccess = false;

        System.out.println("=== Sistem Login ===");

        for (int i = 1; i <= maxAttempts; i++) {
            System.out.println("\nPercobaan " + i + ":");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            // Validasi batas panjang Username (5-10 karakter)
            if (username.length() < 5 || username.length() > 10) {
                System.out.println("Login gagal! Username harus antara 5-10 karakter.");
                continue;
            }
            // Validasi Password (minimal 8 karakter dan ada angka)
            if (password.length() < 8 || !password.matches(".*\\d.*")) {
                System.out.println("Login gagal! Password harus minimal 8 karakter dan mengandung angka.");
                continue;
            }
            // Pengecekan kecocokan akun admin
            if (username.equals("admin") && password.equals("password123")) {
                System.out.println("Login berhasil!");
                isSuccess = true;
                break;
            } else {
                System.out.println("Login gagal! Password salah.");
            }
        }

        if (!isSuccess) {
            System.out.println("\nAkun terkunci! Terlalu banyak percobaan gagal.");
        }
        scanner.close();
    }
}
