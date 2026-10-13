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

public class Lingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14;
        
        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();
        
        if(r < 0) {
            System.out.println("Error: Jari-jari tidak boleh negatif.");
        }else {
            double luas = PI * r * r;
            double keliling = 2 * PI * r;
            System.out.println("Luas: " + luas);
            System.out.println("Keliling: " + keliling);
            
        }
    
    }
}


/*
Pertanyaan Pemantik: 
Mengapa kita perlu validasi r < 0? 
karena jika r lebih kecil daripada 0 maka untuk rumus keliling dan luas tidak akan bisa berjalan
dengan baik dan hasilnya dibilangan minus, tidak dibilangan positif


Dalam aplikasi nyata, di mana validasi input sangat penting? 
dalam pengisian username dan password. Bagian yang menentukan apakah aplikasi benar2 aman atau tidak.
*/