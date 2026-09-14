/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_w02s01;

/**
 *
 * @author Gaudium
 *
 */
// Disini kita menggunakan enchanced for loop (for-each) untuk array agar lebih ringkas
// casting ke double untuk menghindari pembagian integer

public class nilaiRata2Mahasiswa {
    public static void main(String[] args) {
        int[] nilai = {80, 90, 75, 88};
        int total = 0;
        for(int n : nilai){ // enhanced for loop
            total += n;
        }
        double rata = (double)total/nilai.length;
        System.out.println("Rata-rata = " + rata);
    }
}
