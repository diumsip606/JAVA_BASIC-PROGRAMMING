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

public class GradeSystem {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[5];
        double total = 0;
        
        // Input nilai
        for (int i = 0; i < 5; i++) {
            System.out.print("Masukkan nilai ke-" + (i+1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }
        
        // Hitung rata-rata
        double average = total / 5;
        System.out.println ("Rata-rata nilai: " + average);
        
        // Kategori nilai
        char grade;
        if(average >= 85) grade = 'A';
        else if(average >= 70) grade = 'B';
        else if(average >= 60) grade = 'C';
        else if(average >= 50) grade = 'D';
        else grade = 'E';
        
        System.out.println("Grade: " + grade);
        
        // Tampilkan nilai tertinggi dan terendah
        double max = grades[0];
        double min = grades[0];
        
        for(int i = 1; i < 5; i++ ) {
            if(grades[i] > max) max = grades[i];
            if(grades[i] < min) min = grades[i];
        
        }
        
        System.out.println("Nilai tertinggi: " + max);
        System.out.println("Nilai terendah: " + min);      
    }
}


/*
    Pertanyaan Pemantik :
    Apa yang terjadi jika ada nilai yang diinput di luar rentang 0-100? 
    angka tetap muncul sesuai nilai tertinggi di ouputnya tetapi jika kita bisa membuat
    percabangan tambahan jika inputan melebih 100 maka akan muncul teks "nilai maks hanya 100"
    kemudian ada penginputan ulang

    Bagaimana cara memodifikasi program untuk menangani jumlah nilai yang dinamis? 
    berarti maksudnya mahasiswa di input kemudian nilai mahasiswa tersebut yang dimasukkan yaa
    1. kita buat dulu inputan di awal sebelum bikin array buat nanya "berapa jumlah nilai yang mau diinput?", terus angkanya disimpan di variabel baru misal `int n = scanner.nextInt();`
    2. ukuran array yang awalnya dipatok `new double[5]` kita ganti jadi `new double[n]` biar ukurannya menyesuaikan sama inputan awal tadi
    3. angka 5 di dalam perulangan `for` dan pas ngitung rata-rata rata (`total / 5`) juga diganti pakai variabel `n` atau `grades.length` biar perhitungannya ngikutin jumlah data yang dinamis

*/