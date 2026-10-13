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


import java.util.Scanner;
public class ShoppingCart {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] items = new String[100]; // Array penampung item
            int count = 0;
            int choice = 0;
            
            while (choice != 5) {
                System.out.println("\n=== Daftar Belanja ===");
                System.out.println("1. Tambah item");
                System.out.println("2. Hapus item");
                System.out.println("3. Tampilkan semua item");
                System.out.println("4. Cari item");
                System.out.println("5. Keluar");
                System.out.print("Pilihan: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Bersihkan newline
                
                switch (choice) {
                    case 1:
                        if (count < items.length) {
                            System.out.print("Masukkan item: ");
                            items[count] = scanner.nextLine();
                            System.out.println(items[count] + " berhasil ditambahkan!");
                            count++;
                        } else {
                            System.out.println("Daftar belanja penuh!");
                        }
                        break;
                        
                    case 2:
                        System.out.print("Hapus item pada posisi: ");
                        int pos = scanner.nextInt();
                        if (pos >= 1 && pos <= count) {
                            String removedItem = items[pos - 1];
                            // Pergeseran posisi elemen array
                            for (int i = pos - 1; i < count - 1; i++) {
                                items[i] = items[i + 1];
                            }
                            items[count - 1] = null;
                            count--;
                            System.out.println(removedItem + " berhasil dihapus!");
                        } else {
                            System.out.println("Posisi tidak valid!");
                        }
                        break;
                        
                    case 3:
                        if (count == 0) {
                            System.out.println("Daftar belanja kosong.");
                        } else {
                            System.out.println("Daftar belanja:");
                            for (int i = 0; i < count; i++) {
                                System.out.println((i + 1) + ". " + items[i]);
                            }
                        }
                        break;
                        
                    case 4:
                        System.out.print("Cari item: ");
                        String query = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (items[i].equalsIgnoreCase(query)) {
                                System.out.println(items[i] + " ditemukan pada posisi " + (i + 1));
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Item tidak ditemukan.");
                        }
                        break;
                        
                    case 5:
                        System.out.println("Terima kasih!");
                        break;
                        
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        } // Array penampung item
    }
}