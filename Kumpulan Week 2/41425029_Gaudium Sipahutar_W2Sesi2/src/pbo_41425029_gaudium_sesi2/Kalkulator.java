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

public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka pertama: ");
        int a = input.nextInt();
        System.out.print("Masukkan angka kedua: ");
        int b = input.nextInt();
        
        System.out.println("Tambah: " + (a + b ));
        System.out.println("Kurang: " + (a - b ));
        System.out.println("Kali: " + (a * b ));
        System.out.println("Bagi: " + ((double) a / b ));
    }
}


/*

Praktek 1: Apa perbedaan nilai asli double dengan hasil casting int? 
            nilai asli double itu int bisa angka dibelakang koma,
            sedangkan untuk int angka dibelakang koma akan hilang dan 
            menjadi bilangan bulat. Alasan lain, kalo double itu kapasitas angkanya
            lebih besar daripada int

Praktek 2: Mengapa pembagian int perlu di-casting ke double? 
           Karena kalau ga dibikin jadi double, 2 angka dibelakang koma yang terhitung
           akan hilang. Sedangkan int tidak menghitung dan memotong angka koma pada hasil
           dikarenakan int memiliki batas angka.

Praktek 2: Apa risiko jika pembagi = 0?
hasil dari bagi menampilkan ke layar(output) berupa teks "infinity"


*/