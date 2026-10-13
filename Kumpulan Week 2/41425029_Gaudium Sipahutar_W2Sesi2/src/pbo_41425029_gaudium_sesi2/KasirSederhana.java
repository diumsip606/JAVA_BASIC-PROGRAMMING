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

public class KasirSederhana {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Membaca input data belanjaan
        System.out.print("Masukkan nama barang: ");
        String namaBarang = input.nextLine();
        System.out.print("Masukkan harga barang: ");
        double harga = input.nextDouble();
        System.out.print("Masukkan jumlah beli: ");
        int jumlah = input.nextInt();
        // Menhitung total sebelum diskon
        double totalSebelumDiskon = harga * jumlah;
        double diskon = 0;
        // Diskon 10% jika total belanja >= 100.000
        if (totalSebelumDiskon >= 100000) {
            diskon = totalSebelumDiskon * 0.10;
        }
        double totalBayar = totalSebelumDiskon - diskon;
        // Menampilkan hasil rincian pembayaran
        System.out.println("Total sebelum diskon: " + (long) totalSebelumDiskon);
        System.out.println("Diskon: " + (long) diskon);
        System.out.println("Total bayar: " + (long) totalBayar);
        input.close();
    }
}